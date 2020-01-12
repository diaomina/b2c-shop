package com.soft.action.admin;

import com.soft.model.Admin;
import com.soft.service.AdminService;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName AdminAction
 * @Description 管理员控制器
 * @Author ljy
 * @Date 2020/1/12 1:54
 * @Version 1.0
 **/
@Controller
@RequestMapping("/admin")
public class AdminAction {

    @Autowired
    private AdminService adminService;

    /**
     * @Description 跳转到管理员登录界面
     * @Param []
     * @Return java.lang.String
     * @Author ljy
     * @Date 2020/1/12 1:55
     **/
    @RequestMapping("/goLogin")
    public String goLogin() {
        return "admin/login";
    }

    /**
     * @Description 管理员登陆
     * @Param [admin]
     * @Return java.lang.String
     * @Author ljy
     * @Date 2020/1/12 14:32
     **/
    @RequestMapping("/doLogin")
    public String doLogin(@NotNull Admin admin) {
        return "forward:admin/goIndex";
    }

    /**
     * @Description 跳转到后台主页
     * @Param []
     * @Return java.lang.String
     * @Author ljy
     * @Date 2020/1/12 2:02
     **/
    @RequestMapping("/goIndex")
    public String goMain() {
        return "admin/index";
    }

}
