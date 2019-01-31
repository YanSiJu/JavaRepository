package com.heyong.lenrn_net.DAO;

import com.heyong.lenrn_net.POJO.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Create By Yong
 */
public interface UserDAO extends JpaRepository<User,Integer> {

    //查询所有学生或者教师名单
    List<User> findByUserCategory(String userCategory);

    User findUserByUserName(String userName);

}
