package com.heyong.lenrn_net.Service.ServiceImpl;/**
 * Create By Yong
 */

import com.heyong.lenrn_net.DAO.UserDAO;
import com.heyong.lenrn_net.Enums.UserCategoryEnums;
import com.heyong.lenrn_net.POJO.User;
import com.heyong.lenrn_net.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *Create By Yong
 */
@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDAO userDAO;

    @Override
    /**下旬所有用户*/
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    /**查询所有学生*/
    public List<User> findAllStudent() {
        return userDAO.findByUserCategory(UserCategoryEnums.STUDENT.getMessage());
    }

    @Override
    /**查询所有老师*/
    public List<User> findAllTeacher() {
        return userDAO.findByUserCategory(UserCategoryEnums.TEACHER.getMessage());
    }

    @Override
    /**用户注册*/
    public User register(User user) {
        return userDAO.save(user);
    }

    @Override
    /**用户更新*/
    public User updata(User user) {
        logger.info("updata-user:{}",user);
        return userDAO.save(user);
    }

    @Override
    /**获取用户密码*/
    public String getPassword(Integer userId) {
        User user = userDAO.findById(userId).orElse(null);
        String userPassword = user.getUserPassword();
        return userPassword;
    }

    @Override
    public User findById(Integer userId) {
        return userDAO.findById(userId).orElse(null);
    }

    @Override
    public User findUserByUserName(String userName) {
        User user = userDAO.findUserByUserName(userName);
        return user;
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }
}
