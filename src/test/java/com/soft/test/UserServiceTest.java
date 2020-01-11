package com.soft.test;

import com.soft.b2cshop.B2cShopApplication;
import com.soft.model.User;
import com.soft.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


/**
 * @Description UserService测试类
 * @Author ljy
 * @Date 2020/1/11 18:12
 **/
@SpringBootTest(classes = B2cShopApplication.class)
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findAllListUser() {
        List<User> users = userService.findAllListUser();
        for (User user : users) {
            System.out.println(user.toString());
            user.setState((byte) 5);
            System.out.println(user.toString());
        }
    }

    @Test
    public void loadByUserId() {
        User user = userService.loadByUserId(1);
        System.out.println(user.toString());
    }

    @Test
    public void loadByUserName() {
        User user = userService.loadByUserName("user");
        System.out.println(user.toString());
    }

    @Test
    public void createUser() {
        User user = new User();
        user.setUserName("test");
        user.setPassword("123456");
        user.setSex("女");
        user.setPhone("11023123586");
        user.setProvince("四川");
        user.setCity("成都");
        user.setCountry("白云区");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setState((byte) 5);
        int recordNumber = userService.createUser(user);
        System.out.println(recordNumber);
    }

    @Test
    public void delUser() {
        int recordNumber = userService.delUser(2);
        System.out.println(recordNumber);
    }

    @Test
    public void updateUser() {
        User user = userService.loadByUserName("test");
        user.setState((byte) 1);
        int recordNumber = userService.updateUser(user);
        System.out.println(recordNumber);
    }
}