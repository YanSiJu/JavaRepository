package com.heyong.lenrn_net.Service.ServiceImpl;

import com.heyong.lenrn_net.DAO.ResourceDAO;
import com.heyong.lenrn_net.DTO.ResourceDTO;
import com.heyong.lenrn_net.DTO.ResourceUploadDTO;
import com.heyong.lenrn_net.Enums.CategoryEnums;
import com.heyong.lenrn_net.Enums.GradeEnums;
import com.heyong.lenrn_net.Enums.SubjectEnums;
import com.heyong.lenrn_net.POJO.Resource;
import com.heyong.lenrn_net.ResourceVO.ResourceCategoryVO;
import com.heyong.lenrn_net.ResourceVO.ResourceGradeVO;
import com.heyong.lenrn_net.ResourceVO.ResourceSubjectVO;
import com.heyong.lenrn_net.ResourceVO.ResultVO;
import com.heyong.lenrn_net.Service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create By Yong
 */

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDAO resourceDAO;

    private static Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);



    @Override
    public ResultVO findAll(){

        List<Resource> resourceList = resourceDAO.findAll();

        //创建数据第一层
        ResultVO resultVO = new ResultVO();

        //创建数据第二层
        List<ResourceCategoryVO> resourceCategoryVOList = new ArrayList<>();

        for(int i=0;i<CategoryEnums.getAllMessage().length;i++){
            ResourceCategoryVO resourceCategoryVO = new ResourceCategoryVO();
            resourceCategoryVO.setResourceCategory(CategoryEnums.getAllMessage()[i]);


            //创建数据第三层
            List<ResourceGradeVO> resourceGradeVOList = new ArrayList<>();
            for(int j=0;j<GradeEnums.getAllMessage().length;j++){
                ResourceGradeVO resourceGradeVO = new ResourceGradeVO();
                resourceGradeVO.setResourceGrade(GradeEnums.getAllMessage()[j]);

                //创建数据第四层
                List<ResourceSubjectVO> resourceSubjectVOList = new ArrayList<>();
                for(int z=0;z<SubjectEnums.getAllMessage().length;z++){
                    ResourceSubjectVO resourceSubjectVO = new ResourceSubjectVO();
                    resourceSubjectVO.setResourceSubject(SubjectEnums.getAllMessage()[z]);

                    List<ResourceDTO> resourceDTOList = new ArrayList<>();
                    for(Resource resource:resourceList){
//                        logger.info("resourceName1:{}",resource.getResourceName());
                        if(resource.getResourceCategory().equals(CategoryEnums.getAllMessage()[i])&&resource.getResourceGrade().equals(GradeEnums.getAllMessage()[j])&&
                                resource.getResourceSubject().equals(SubjectEnums.getAllMessage()[z])){

                            ResourceDTO resourceDTO = new ResourceDTO();

                            //属性拷贝
                            BeanUtils.copyProperties(resource,resourceDTO);
                            resourceDTOList.add(resourceDTO);
                        }
                    }

                    //添加List<ResourceDTO>
                    resourceSubjectVO.setResourceDTOList(resourceDTOList);
                    resourceSubjectVOList.add(resourceSubjectVO);
                }

                //添加ResourceSubject
                resourceGradeVO.setResourceSubjectVOList(resourceSubjectVOList);
                resourceGradeVOList.add(resourceGradeVO);
            }

            resourceCategoryVO.setResourceGradeVOList(resourceGradeVOList);
            resourceCategoryVOList.add(resourceCategoryVO);
        }

        resultVO.setCode(0);
        resultVO.setMessage("success");
        resultVO.setList(resourceCategoryVOList);

        return resultVO;
    }

    @Override
    public Resource findById(Integer reourceId) {
        return resourceDAO.findById(reourceId).orElse(null);
    }


    @Override
    public String getResourceAddress(Resource resource) {
        return resource.getResourceAddress();
    }

    @Override
    public Resource addResource(Resource resource) {
        return resourceDAO.save(resource);
    }

    @Override
    public Resource updateResource(Resource resource) {
        return resourceDAO.save(resource);
    }

    @Override
    public void deleteResource(Resource resource) {
        resourceDAO.delete(resource);
    }

    @Override
    public List<ResourceUploadDTO> findResourcesByUploadId(Integer uploaderId) {
        List<ResourceUploadDTO> resourceUploadDTOList = resourceDAO.findResourcesByUploaderId(uploaderId).stream().map(e->new ResourceUploadDTO(e.getResourceId(),e.getResourceName(),
                e.getResourceCategory(),e.getResourceSubject(),e.getResourceGrade(),e.getResourceCreatetime(),e.getResourceDownloads())).collect(Collectors.toList());
        return resourceUploadDTOList;
    }

    @Override
    public List<ResourceDTO> findResourceByResourceSubject(String resourceSubject) {
        List<Resource> resourceList = resourceDAO.findResourcesByResourceSubject(resourceSubject);
        List<ResourceDTO> resourceDTOList = resourceList.stream().map(e->new ResourceDTO(e.getResourceId(),
                e.getResourceName(),e.getResourceAddress(),e.getResourceCreatetime(),e.getResourceDownloads(),e.getUploaderId(),e.getResourceImg())).collect(Collectors.toList());
        return resourceDTOList;
    }

    @Override
    public List<ResourceDTO> findByResourceSubjectAndGrade(String resourceSubject, String resourceGrade) {
        List<Resource> resourceList = null;
        if(resourceGrade.equals("all")){
            resourceList = resourceDAO.findResourcesByResourceSubject(resourceSubject);
        }else {
            resourceList = resourceDAO.findResourcesByResourceSubjectAndResourceGrade(resourceSubject,resourceGrade);
        }
        List<ResourceDTO> resourceDTOList = resourceList.stream().map(e->new ResourceDTO(e.getResourceId(),
                e.getResourceName(),e.getResourceAddress(),e.getResourceCreatetime(),e.getResourceDownloads(),e.getUploaderId(),e.getResourceImg())).collect(Collectors.toList());
        return resourceDTOList;
    }

    //搜索模块
    @Override
    public List<ResourceDTO> findByResourceNameLike(String resourceName) {
        List<ResourceDTO> resourceDTOList = resourceDAO.findByResourceNameLike(resourceName).stream().map(e->new ResourceDTO(e.getResourceId(),e.getResourceName(),e.getResourceAddress(),e.getResourceCreatetime(),
                e.getResourceDownloads(),e.getUploaderId(),e.getResourceImg())).collect(Collectors.toList());
        return resourceDTOList;
    }

    @Override
    public List<Resource> getAll() {
        return resourceDAO.findAll();
    }
}
