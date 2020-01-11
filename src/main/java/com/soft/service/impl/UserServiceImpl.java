package com.soft.service.impl;

import com.soft.mapper.UserMapper;
import com.soft.model.User;
import com.soft.model.UserExample;
import com.soft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description 用户业务接口实现类
 * @Author ljy
 * @Date 2020/1/11 3:53
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * @Description 查询所有用户
     * @Param []
     * @Return java.util.List<com.soft.model.User>
     * @Date 2020/1/11 17:26
     **/
    @Override
    public List<User> findAllListUser() {
        return userMapper.selectByExample(null);
    }

    /**
     * @Description 根据user_id查询用户
     * @Param []
     * @Return com.soft.model.User
     * @Date 2020/1/11 17:56
     **/
    @Override
    public User loadByUserId(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    /**
     * @Description 根据user_name查询用户
     * @Param []
     * @Return com.soft.model.User
     * @Date 2020/1/11 17:57
     **/
    @Override
    public User loadByUserName(String userName) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<User> users = userMapper.selectByExample(userExample);
        if(users != null && users.size() > 0){
            return users.get(0);
        }
        return null;
    }

    /**
     * @Description 创建用户
     * @Param [user]
     * @Return int
     * @Date 2020/1/11 17:59
     */
    @Override
    public int createUser(User user) {
        return userMapper.insertSelective(user);
    }

    /**
     * @Description 删除用户
     * @Param [userId]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 18:00
     */
    @Override
    public int delUser(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    /**
     * @Description 更新用户
     * @Param [user]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 18:00
     */
    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

}
