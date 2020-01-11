package com.soft.action;

import com.soft.model.User;
import com.soft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserAction
 * @Description 用户控制器
 * @Author ljy
 * @Date 2020/1/11 14:25
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserAction {

    @Autowired
    private UserService userService;

    @RequestMapping("/goUserMain")
    public List<User> goUserMain() {
        List<User> users = userService.findAllListUser();
        return users;
    }

}
