package com.heyong.lenrn_net.DAO;

import com.heyong.lenrn_net.POJO.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Create By Yong
 */
public interface ExhibitionDAO extends JpaRepository<Exhibition,Integer> {

    //通过用户ID查询展览
    List<Exhibition> findExhibitioByUserId(Integer userId);
}
