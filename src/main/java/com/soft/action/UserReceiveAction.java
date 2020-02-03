package com.soft.action;

import com.alibaba.fastjson.JSONObject;
import com.soft.model.User;
import com.soft.model.UserReceive;
import com.soft.service.UserReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName UserReceiveAction
 * @Description 用户中心-地址管理控制器
 * @Author ljy
 * @Date 2020/2/2 17:15
 * @Version 1.0
 **/
@Controller
@RequestMapping("/userReceiveAction")
public class UserReceiveAction {

    @Autowired
    private UserReceiveService userReceiveService;


    /**
     * @Description 跳转到地址管理界面
     * @Param [session]
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/2/2 17:19
     **/
    @RequestMapping("/goUserReceiveMain")
    public ModelAndView goUserReceiveMain(HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<UserReceive> userReceiveList = userReceiveService.findListByUserId(user.getUserId());
        // 过滤已删除的地址
        Iterator<UserReceive> iterator = userReceiveList.iterator();
        while(iterator.hasNext()) {
            UserReceive userReceive = iterator.next();
            if(userReceive.getDelState() == 1) {
                iterator.remove();
            }
        }
        return new ModelAndView("user/user_center/user_receive/user_receive_main", "userReceiveList", userReceiveList);
    }


    /**
     * @Description 跳转到地址添加界面
     * @Param []
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/2/2 19:29
     **/
    @RequestMapping("/goUserReceiveAdd")
    public ModelAndView goUserReceiveAdd(){
        return new ModelAndView("user/user_center/user_receive/user_receive_add");
    }

    /**
     * @Description 地址添加
     * @Param [userReceive, session]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/2/2 19:25
     **/
    @RequestMapping("/doUserReceiveAdd")
    @ResponseBody
    public JSONObject doUserReceiveAdd(UserReceive userReceive,HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        User user = (User) session.getAttribute("user");
        userReceive.setUserId(user.getUserId());
        userReceive.setCreateTime(new Date());
        userReceive.setUpdateTime(new Date());
        // 判断添加结果
        if (userReceiveService.createUserReceive(userReceive) > 0) {
            jsonObject.put("flag", "true");
        } else {
            jsonObject.put("flag", "false");
        }
        return jsonObject;
    }


    /**
     * @Description 跳转到地址编辑界面
     * @Param [receiveId]
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/2/3 15:21
     **/
    @RequestMapping("/goUserReceiveEdit")
    public ModelAndView goUserReceiveEdit(Integer receiveId) {
        return new ModelAndView("user/user_center/user_receive/user_receive_edit", "userReceive", userReceiveService.loadById(receiveId));
    }

    @RequestMapping("/doUserReceiveEdit")
    @ResponseBody
    public JSONObject doUserReceiveEdit(UserReceive userReceive) {
        JSONObject jsonObject = new JSONObject();
        UserReceive dbUserReceive = userReceiveService.loadById(userReceive.getReceiveId());
        dbUserReceive.setContact(userReceive.getContact());
        dbUserReceive.setTel(userReceive.getTel());
        dbUserReceive.setReceiveProvince(userReceive.getReceiveProvince());
        dbUserReceive.setReceiveCity(userReceive.getReceiveCity());
        dbUserReceive.setReceiveCounty(userReceive.getReceiveCounty());
        dbUserReceive.setReceiveAddress(userReceive.getReceiveAddress());
        dbUserReceive.setUpdateTime(new Date());

        // 判断更新结果
        if (userReceiveService.updateUserReceive(dbUserReceive) > 0) {
            jsonObject.put("flag", "true");
        } else {
            jsonObject.put("flag", "false");
        }
        return jsonObject;
    }


    /**
     * @Description 地址删除
     * @Param [receiveId]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/2/3 15:48
     **/
    @RequestMapping("/doUserReceiveDelete")
    @ResponseBody
    public JSONObject doUserReceiveDelete(Integer receiveId) {
        JSONObject jsonObject = new JSONObject();
        UserReceive userReceive = userReceiveService.loadById(receiveId);
        userReceive.setDelState((byte) 1);
        // 判断更新结果
        if (userReceiveService.updateUserReceive(userReceive) > 0) {
            jsonObject.put("flag", "true");
        } else {
            jsonObject.put("flag", "false");
        }
        return jsonObject;
    }


    /**
     * @Description 设为默认地址
     * @Param [receiveId]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/2/3 15:08
     **/
    @RequestMapping("/doDefault")
    @ResponseBody
    public JSONObject doDefault(Integer receiveId) {
        JSONObject jsonObject = new JSONObject();
        // 判断设置结果
        if (userReceiveService.setDefault(receiveId) > 0) {
            jsonObject.put("flag", "true");
        } else {
            jsonObject.put("flag", "false");
        }
        return jsonObject;
    }
}
