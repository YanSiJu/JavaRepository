package com.heyong.lenrn_net.DAO;

import com.heyong.lenrn_net.POJO.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Create By Yong
 */
@Repository
public interface ResourceDAO extends JpaRepository<Resource,Integer> {

    List<Resource> findResourcesByUploaderId(Integer uploadId);

    Page<Resource> findResourcesByUploaderId(Integer uploadId,Pageable pageable);

    List<Resource> findResourcesByResourceSubject(String resourceSubject);

    List<Resource> findResourcesByResourceSubjectAndResourceGrade(String resourceSubject,String resourceGrade);

    @Query(value = "select r from Resource r where r.resourceName LIKE CONCAT('%',:resourceName,'%')")
    List<Resource> findByResourceNameLike(@Param("resourceName") String resourceName);

}
