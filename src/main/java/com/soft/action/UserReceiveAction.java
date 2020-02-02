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
        return new ModelAndView("user/user_center/user_receive/user_receive_main", "userReceiveList", userReceiveService.findListByUserId(user.getUserId()));
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

}
