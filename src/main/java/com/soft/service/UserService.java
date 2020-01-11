package com.soft.service;

import com.soft.model.User;

import java.util.List;

/**
 * @Description 用户业务接口
 * @Author ljy
 * @Date 2020/1/11 17:59
 **/
public interface UserService {

    /**
     * @Description 查询所有用户
     * @Param []
     * @Return java.util.List<com.soft.model.User>
     * @Date 2020/1/11 17:26
     **/
    List<User> findAllListUser();

    /**
     * @Description 根据user_id查询用户
     * @Param []
     * @Return com.soft.model.User
     * @Date 2020/1/11 17:56
     **/
    User loadByUserId(Integer userId);

    /**
     * @Description 根据user_name查询用户
     * @Param []
     * @Return com.soft.model.User
     * @Date 2020/1/11 17:57
     **/
    User loadByUserName(String userName);

    /**
     * @Description 创建用户
     * @Param [user]
     * @Return int
     * @Date 2020/1/11 17:59
     **/
    int createUser(User user);

    /**
     * @Description 删除用户
     * @Param [userId]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 18:00
     **/
    int delUser(Integer userId);

    /**
     * @Description 更新用户
     * @Param [user]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 18:00
     **/
    int updateUser(User user);

}
