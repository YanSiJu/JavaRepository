package com.heyong.lenrn_net.Service;/**
 * Create By Yong
 */

import com.heyong.lenrn_net.POJO.User;

import java.util.List;

/**
 *
 *Create By Yong
 */
public interface UserService {

    List<User> findAll();

    List<User> findAllStudent();

    List<User> findAllTeacher();

    //学生注册
    User register(User user);

    //用户更改
    User updata(User user);

    //获得用户密码
    String getPassword(Integer userId);

    User findById(Integer userId);

    User findUserByUserName(String userName);

    void delete(User user);

}
