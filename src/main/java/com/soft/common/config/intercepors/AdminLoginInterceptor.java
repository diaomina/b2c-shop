package com.soft.common.config.intercepors;

import com.soft.model.Admin;
import com.soft.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName AdminLoginInterceptor
 * @Description 管理员登录拦截器
 * @Author ljy
 * @Date 2020/2/15 1:21
 * @Version 1.0
 **/
@Component
public class AdminLoginInterceptor implements HandlerInterceptor {

    //访问之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //每一个项目对于登陆的实现逻辑都有所区别，我这里使用最简单的Session提取User来验证登陆。
        HttpSession session = request.getSession();
        //这里是登陆时放入session的
        Admin admin = (Admin) session.getAttribute("admin");
        //如果session中没有user，表示没登陆
        if (admin == null){
            //这个方法返回false表示忽略当前请求，如果一个用户调用了需要登陆才能使用的接口，如果他没有登陆这里会直接忽略掉
            //直接重定向到登录页面
            response.sendRedirect(request.getContextPath()+"/adminAction/goLogin");
            return false;
        }else {
            return true;    //如果session里有user，表示该用户已经登陆，放行，用户即可继续调用自己需要的接口
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}