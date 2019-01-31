package com.heyong.lenrn_net.DAO;

import com.heyong.lenrn_net.POJO.Collect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create By Yong
 */

@Repository
public interface CollectDAO extends JpaRepository<Collect,Integer> {

    List<Collect> findCollectsByUserId(Integer userId);

    void deleteByResourceIdAndUserId(Integer resourceId,Integer userId);

    Collect findByResourceIdAndUserId(Integer resourceId,Integer userId);
}
