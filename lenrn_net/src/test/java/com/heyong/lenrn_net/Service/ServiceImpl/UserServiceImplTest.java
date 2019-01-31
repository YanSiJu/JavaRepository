package com.heyong.lenrn_net.Service.ServiceImpl;

import com.heyong.lenrn_net.DAO.UserDAO;
import com.heyong.lenrn_net.POJO.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Create By Yong
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void findAll() {
    }

    @Test
    public void findAllStudent() {
    }

    @Test
    public void findAllTeacher() {
    }

    @Test
    public void register() {
    }

    @Test
    public void updata() {
        User user = new User();
        user.setUserId(10000);
        user.setUserName("黄浩楠");

        userDAO.save(user);
    }

    @Test
    public void getPassword() {
    }
    @Test
    public void findUserByUserName() {
        String userName = "黄浩楠";
        User user = userDAO.findUserByUserName(userName);
        user.getUserId();
    }
}