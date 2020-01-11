package com.soft.service;

import com.soft.model.Admin;

/**
 * @Description 管理员业务接口
 * @Author ljy
 * @Date 2020/1/11 18:53
 **/
public interface AdminService {

    /**
     * @Description 根据用户名查询管理员
     * @Param [adminName]
     * @Return com.soft.model.Admin
     * @Author ljy
     * @Date 2020/1/11 18:54
     **/
    Admin loadByUserName(String adminName);

    /**
     * @Description 根据admin_id查询管理员
     * @Param [adminId]
     * @Return com.soft.model.Admin
     * @Author ljy
     * @Date 2020/1/11 18:55
     **/
    Admin loadByAdminId(Integer adminId);

    /**
     * @Description 更新管理员
     * @Param [admin]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 18:55
     **/
    int updateAdmin(Admin admin);


}
