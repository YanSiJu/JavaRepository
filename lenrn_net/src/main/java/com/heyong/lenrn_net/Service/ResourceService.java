package com.heyong.lenrn_net.Service;

import com.heyong.lenrn_net.DAO.ResourceDAO;
import com.heyong.lenrn_net.DTO.ResourceDTO;
import com.heyong.lenrn_net.DTO.ResourceUploadDTO;
import com.heyong.lenrn_net.POJO.Resource;
import com.heyong.lenrn_net.ResourceVO.ResultVO;

import java.util.List;

/**
 * Create By Yong
 */
public interface ResourceService {


    public ResultVO findAll();

    public List<Resource> getAll();

    /**通过Id获得资源*/
    public Resource findById(Integer reourceId);

    /** 添加资源 */
    public Resource addResource(Resource resource);

    /** 修改资源 */
    public Resource updateResource(Resource resource);

    /** 删除资源 */
    public void deleteResource(Resource resource);


    String getResourceAddress(Resource resource);

    List<ResourceUploadDTO> findResourcesByUploadId(Integer uploaderId);

    List<ResourceDTO> findResourceByResourceSubject(String resourceSubject);

    List<ResourceDTO> findByResourceSubjectAndGrade(String resourceSubject,String resourceGrade);

    //搜索模块
    List<ResourceDTO> findByResourceNameLike(String resourceName);
}
