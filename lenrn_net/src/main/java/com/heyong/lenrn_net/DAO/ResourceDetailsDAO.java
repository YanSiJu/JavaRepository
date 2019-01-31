package com.heyong.lenrn_net.DAO;

import com.heyong.lenrn_net.POJO.ResourceDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Create By Yong
 */
public interface ResourceDetailsDAO extends JpaRepository<ResourceDetails,Integer> {

    ResourceDetails findByResourceId(Integer resourceId);
}
