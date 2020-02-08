package com.soft.action;

import com.alibaba.fastjson.JSONObject;
import com.soft.common.util.Md5;
import com.soft.model.User;
import com.soft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName UserManagerAction
 * @Description 用户管理控制器
 * @Author ljy
 * @Date 2020/1/12 17:17
 * @Version 1.0
 **/
@Controller
@RequestMapping("/userAction")
public class UserAction {

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
     * @Description 用户添加
     * @Param [user]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/1/12 20:01
     **/
    @RequestMapping("/doUserAdd")
    @ResponseBody
    public JSONObject doUserAdd(User user) throws Exception {
        JSONObject jsonObject = new JSONObject();
        User dbUser = userService.loadByUserName(user.getUserName());
        // 判断用户名是否已存在
        if(dbUser != null) {
            // 存在
            jsonObject.put("flag","exist");
        } else {
            // 不存在
            user.setPassword(Md5.md5(user.getPassword()));  // md5加密
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            // 判断添加是否成功
            if(userService.createUser(user) > 0) {
                jsonObject.put("flag","true");
            } else {
                jsonObject.put("flag","false");
            }
        }
        return jsonObject;
    }


    /**
     * @Description 跳转到用户修改界面
     * @Param [userId]
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/1/13 19:04
     **/
    @RequestMapping("/goUserEdit")
    public ModelAndView goUserEdit(Integer userId){
        User user = userService.loadByUserId(userId);
        return new ModelAndView("admin/user_manager/user_edit", "user", user);
    }


    /**
     * @Description 用户修改
     * @Param [user]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/1/13 23:30
     **/
    @RequestMapping("/doUserEdit")
    @ResponseBody
    public JSONObject doUserEdit(User user){
        JSONObject jsonObject = new JSONObject();
        // 更新状态
        User dbUser = userService.loadByUserId(user.getUserId());
        dbUser.setUserName(user.getUserName());
        dbUser.setUserAmount(user.getUserAmount());
        dbUser.setSex(user.getSex());
        dbUser.setPhone(user.getPhone());
        dbUser.setProvince(user.getProvince());
        dbUser.setCity(user.getCity());
        dbUser.setCountry(user.getCountry());
        dbUser.setUpdateTime(new Date());
        // 判断修改是否成功
        if(userService.updateUser(dbUser) > 0) {
            jsonObject.put("flag","true");
        } else {
            jsonObject.put("flag","false");
        }
        return jsonObject;
    }


    /**
     * @Description 跳转到用户修改密码界面
     * @Param [userId]
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/1/13 23:39
     **/
    @RequestMapping("/goUserChangePassword")
    public ModelAndView goUserChangePassword(Integer userId){
        return new ModelAndView("admin/user_manager/user_change_password","user",userService.loadByUserId(userId));
    }


    /**
     * @Description 用户修改密码
     * @Param [user]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/1/13 23:34
     **/
    @RequestMapping("/doUserChangePassword")
    @ResponseBody
    public JSONObject doUserChangePassword(User user) throws Exception {
        System.out.println(user.toString());
        JSONObject jsonObject = new JSONObject();
        User dbUser = userService.loadByUserId(user.getUserId());
        dbUser.setPassword(Md5.md5(user.getPassword()));
        dbUser.setUpdateTime(new Date());
        // 判断更新结果
        if (userService.updateUser(dbUser) > 0) {
            jsonObject.put("flag", "true");
        } else {
            jsonObject.put("flag", "false");
        }
        return jsonObject;
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
        // 启用
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
        return jsonObject;
    }


    /**
     * @Description 用户 批量停用
     * @Param []
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/1/14 17:22
     **/
    @RequestMapping("/stopBatchUser")
    @ResponseBody
    public JSONObject stopBatchUser(Integer[] userIds) {
        JSONObject jsonObject = new JSONObject();
        List<Integer> list = new ArrayList<Integer>();
        for (Integer userId : userIds) {
            list.add(userId);
        }
        int recordNumber = userService.stopBatchUser(list);
        if(recordNumber == list.size()){
            jsonObject.put("flag", "true");
        } else {
            jsonObject.put("flag", "false");
            jsonObject.put("number", list.size() - recordNumber);
        }
        return jsonObject;
    }


    /**
     * @Description 跳转到用户登录界面
     * @Param []
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/1/29 18:56
     **/
    @RequestMapping("/goLogin")
    public ModelAndView goLogin(HttpSession session) {
        return new ModelAndView("user/login");
    }


    /**
     * @Description 用户登录
     * @Param [user, session]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/1/29 20:32
     **/
    @RequestMapping("/doLogin")
    @ResponseBody
    public JSONObject doLogin(User user, HttpSession session) throws Exception {
        JSONObject jsonObject = new JSONObject();
        User dbUser = userService.loadByUserName(user.getUserName());
        // 判断用户是否存在
        if(dbUser != null){
            // 校验密码
            if(Md5.verify(user.getPassword(), dbUser.getPassword())){
                session.setAttribute("user", dbUser);
                jsonObject.put("flag","true");
            } else {
                jsonObject.put("flag","falseByPassword");
            }
        } else {
            jsonObject.put("flag","falseByUserName");
        }
        return jsonObject;
    }


    /**
     * @Description 跳转到用户注册界面
     * @Param []
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/1/29 18:56
     **/
    @RequestMapping("/goRegist")
    public ModelAndView goRegist(HttpSession session) {
        return new ModelAndView("user/regist");
    }


    /**
     * @Description 用户中心-跳转到我的信息界面界面
     * @Param [session]
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/2/1 14:34
     **/
    @RequestMapping("/goUserCenter")
    public ModelAndView goUserCenter(HttpSession session) {
        User user = (User) session.getAttribute("user");
        // 从数据库中拉取最新的数据，否则在用户中心-我的信息中修改数据后，界面刷新后显示的依旧是session中保存的数据
        User dbUser = userService.loadByUserId(user.getUserId());
        return new ModelAndView("user/user_center/user_info", "user", dbUser);
    }


    /**
     * @Description 用户中心-跳转到修改密码界面
     * @Param []
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/2/1 16:56
     **/
    @RequestMapping("/goChangePassword")
    public ModelAndView goChangePassword() {
        return new ModelAndView("user/user_center/change_password");
    }


    /**
     * @Description 用户中心-跳转到账户余额界面
     * @Param [session]
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/2/8 16:25
     **/
    @RequestMapping("/goUserAmount")
    public ModelAndView goUserAmount(HttpSession session) {
        User user = (User) session.getAttribute("user");
        User dbUser = userService.loadByUserId(user.getUserId());
        return new ModelAndView("user/user_center/user_amount", "user", dbUser);
    }


    /**
     * @Description 账户余额充值
     * @Param [user]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/2/8 16:41
     **/
    @RequestMapping("/doUserAmount")
    @ResponseBody
    public JSONObject doUserAmount(Integer userId, Double userAmount) {
        JSONObject jsonObject = new JSONObject();
        // 更新数据
        User user = userService.loadByUserId(userId);
        user.setUserAmount(user.getUserAmount() + (int)(userAmount * 100));
        user.setUpdateTime(new Date());
        // 判断是否更新成功
        if(userService.updateUser(user) > 0){
            jsonObject.put("flag", "true");
        } else {
            jsonObject.put("flag", "false");
        }
        return jsonObject;
    }

}
