package com.soft.action.admin;

import com.alibaba.fastjson.JSONObject;
import com.soft.model.User;
import com.soft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.DoubleToIntFunction;

/**
 * @ClassName UserManagerAction
 * @Description 用户管理控制器
 * @Author ljy
 * @Date 2020/1/12 17:17
 * @Version 1.0
 **/
@Controller
@RequestMapping("/userManager")
public class UserManagerAction {

    @Autowired
    private UserService userService;

    /**
     * @Description 跳转到用户管理主界面
     * @Param []
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/1/12 17:23
     **/
    @RequestMapping("/goUserMain")
    public ModelAndView goUserMain(){
        List<User> users = userService.findAllListUser();
        return new ModelAndView("admin/user_manager/user_main","users",users);
    }

    /**
     * @Description 跳转到用户添加界面
     * @Param []
     * @Return java.lang.String
     * @Author ljy
     * @Date 2020/1/12 19:06
     **/
    @RequestMapping("/goUserAdd")
    public String goUserAdd() {
        return "admin/user_manager/user_add";
    }

    /**
     * @Description
     * @Param []
     * @Return java.lang.String
     * @Author ljy
     * @Date 2020/1/12 20:01
     **/
    @RequestMapping("/doUserAdd")
    public void doUserAdd(User user) {
        System.out.println(user.toString());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userService.createUser(user);
    }

    /**
     * @Description 用户 启用/停用
     * @Param [userId, state]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/1/13 2:15
     **/
    @RequestMapping("/doUserState")
    @ResponseBody
    public JSONObject doUserState(Integer userId, String state){
        JSONObject jsonObject = new JSONObject();
        // 查询此用户
        User user = userService.loadByUserId(userId);
        //启用
        // 停用
        if("start".equals(state)) {
            user.setState((byte) 1);
        }
        // 停用
        if("stop".equals(state)) {
            user.setState((byte) 0);
        }
        // 判断更新结果
        if (userService.updateUser(user) > 0) {
            jsonObject.put("flag", "true");
        } else {
            jsonObject.put("flag", "false");
        }
        //将userId返回界面
        jsonObject.put("userId", userId);
        return jsonObject;
    }



}
