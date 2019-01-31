package com.heyong.lenrn_net.Controller;

import com.heyong.lenrn_net.Enums.SexEnums;
import com.heyong.lenrn_net.Enums.UserCategoryEnums;
import com.heyong.lenrn_net.POJO.User;
import com.heyong.lenrn_net.Service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.*;

/**
 * Create By Yong
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(UserControllerTest.class);

    @Autowired
    private UserService userService;

    @Test
    public void getAll() {
        List<User> list = userService.findAll();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void getAllStudent() {
        List<User> list = userService.findAllStudent();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void getAllTeacher() {
        List<User> list = userService.findAllTeacher();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void register() {
        User user = new User();
        user.setUserName("胡第三");
        user.setUserPassword("123456");
        user.setUserSex(SexEnums.MAN.getMessage());
        user.setUserTel(13963588412L);
        user.setUserCategory(UserCategoryEnums.TEACHER.getMessage());
        user.setUserDescription("一个人走走");

        userService.register(user);
    }

    @Test
    public void updata() {
        User user = new User();
        user.setUserId(10000);
        user.setUserName("黄浩");
        user.setUserPassword("123456");
        user.setUserTel(13963587412L);
        user.setUserSex(SexEnums.MAN.getMessage());
        user.setUserCategory(UserCategoryEnums.STUDENT.getMessage());
        user.setUserDescription("帅气迷人");

        userService.register(user);
    }

    @Test
    public void getUserPassword() {
        Integer userId = new Integer(10001);
        String password = userService.getPassword(userId).toString();
        logger.info("密码：{}",password);
    }
}