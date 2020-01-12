package com.soft.service.impl;

import com.soft.mapper.UserReceiveMapper;
import com.soft.model.UserReceive;
import com.soft.model.UserReceiveExample;
import com.soft.service.UserReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserReceiveServiceImpl
 * @Description UserReceiveService的实现类
 * @Author ljy
 * @Date 2020/1/11 23:50
 * @Version 1.0
 **/
@Service
public class UserReceiveServiceImpl implements UserReceiveService {

    @Autowired
    private UserReceiveMapper userReceiveMapper;

    /**
     * @Description 根据用户id查询
     * @Param [userId]
     * @Return java.util.List<com.soft.model.UserReceive>
     * @Author ljy
     * @Date 2020/1/11 23:46
     */
    @Override
    public List<UserReceive> findListByUserId(Integer userId) {
        UserReceiveExample userReceiveExample = new UserReceiveExample();
        UserReceiveExample.Criteria criteria = userReceiveExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return userReceiveMapper.selectByExample(userReceiveExample);
    }

    /**
     * @Description 根据收货id查询
     * @Param [receiveId]
     * @Return com.soft.model.UserReceive
     * @Author ljy
     * @Date 2020/1/11 23:48
     */
    @Override
    public UserReceive loadById(Integer receiveId) {
        return userReceiveMapper.selectByPrimaryKey(receiveId);
    }

    /**
     * @Description 添加收货地址
     * @Param [userReceive]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 23:49
     */
    @Override
    public int createUserReceive(UserReceive userReceive) {
        return userReceiveMapper.insertSelective(userReceive);
    }

    /**
     * @Description 删除收货地址
     * @Param [receiveId]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 23:49
     */
    @Override
    public int delUserReceive(Integer receiveId) {
        UserReceive userReceive = userReceiveMapper.selectByPrimaryKey(receiveId);
        userReceive.setDelState((byte) 1);
        return userReceiveMapper.updateByPrimaryKeySelective(userReceive);
    }

    /**
     * @Description 修改收货地址
     * @Param [userReceive]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 23:49
     */
    @Override
    public int updateUserReceive(UserReceive userReceive) {
        return userReceiveMapper.updateByPrimaryKeySelective(userReceive);
    }
}
