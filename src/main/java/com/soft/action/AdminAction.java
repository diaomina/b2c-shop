package com.soft.action;

import com.alibaba.fastjson.JSONObject;
import com.soft.common.util.Md5;
import com.soft.model.Admin;
import com.soft.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @ClassName AdminAction
 * @Description 管理员控制器
 * @Author ljy
 * @Date 2020/1/12 1:54
 * @Version 1.0
 **/
@Controller
@RequestMapping("/adminAction")
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
     * @Param [admin, session]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/1/16 15:20
     **/
    @RequestMapping("/doLogin")
    @ResponseBody
    public JSONObject doLogin(Admin admin, HttpSession session) throws Exception {
        JSONObject jsonObject = new JSONObject();
        Admin dbAdmin = adminService.loadByUserName(admin.getAdminName());
        // 判断管理员是否存在
        if(dbAdmin != null){
            // 校验密码
            if(Md5.verify(admin.getPassword(), dbAdmin.getPassword())){
                session.setAttribute("admin", dbAdmin);
                jsonObject.put("flag","true");
            } else {
                jsonObject.put("flag","falseByPassword");
            }
        } else {
            jsonObject.put("flag","falseByAdminName");
        }
        return jsonObject;
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
