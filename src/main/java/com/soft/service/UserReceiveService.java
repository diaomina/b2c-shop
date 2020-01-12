package com.soft.service;

import com.soft.model.UserReceive;

import java.util.List;

/**
 * @Description 用户收货地址的业务接口
 * @Author ljy
 * @Date 2020/1/11 23:45
 **/
public interface UserReceiveService {

    /**
     * @Description 根据用户id查询
     * @Param [userId]
     * @Return java.util.List<com.soft.model.UserReceive>
     * @Author ljy
     * @Date 2020/1/11 23:46
     **/
    List<UserReceive> findListByUserId(Integer userId);

    /**
     * @Description 根据收货id查询
     * @Param [receiveId]
     * @Return com.soft.model.UserReceive
     * @Author ljy
     * @Date 2020/1/11 23:48
     **/
    UserReceive loadById(Integer receiveId);

    /**
     * @Description 添加收货地址
     * @Param [userReceive]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 23:49
     **/
    int createUserReceive(UserReceive userReceive);

    /**
     * @Description 删除收货地址
     * @Param [receiveId]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 23:49
     **/
    int delUserReceive(Integer receiveId);

    /**
     * @Description 修改收货地址
     * @Param [userReceive]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 23:49
     **/
    int updateUserReceive(UserReceive userReceive);
}
