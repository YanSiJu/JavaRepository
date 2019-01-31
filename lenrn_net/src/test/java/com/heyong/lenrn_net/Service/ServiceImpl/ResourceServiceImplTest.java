package com.heyong.lenrn_net.Service.ServiceImpl;

import com.heyong.lenrn_net.DAO.ResourceDAO;
import com.heyong.lenrn_net.DTO.ResourceDTO;
import com.heyong.lenrn_net.Enums.CategoryEnums;
import com.heyong.lenrn_net.Enums.GradeEnums;
import com.heyong.lenrn_net.Enums.SubjectEnums;
import com.heyong.lenrn_net.POJO.Resource;
import com.heyong.lenrn_net.ResourceVO.ResourceCategoryVO;
import com.heyong.lenrn_net.ResourceVO.ResourceGradeVO;
import com.heyong.lenrn_net.ResourceVO.ResourceSubjectVO;
import com.heyong.lenrn_net.ResourceVO.ResultVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Create By Yong
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceServiceImplTest {

    @Autowired
    private ResourceDAO resourceDAO;

    private static Logger logger = LoggerFactory.getLogger(ResourceServiceImplTest.class);

    @Test
    public void finAll() {
    }

    @Test
    public void findAll() {

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
                        logger.info("getResourceCategory{}:,2:{}",resource.getResourceCategory(),CategoryEnums.getAllMessage()[i]);
                        logger.info("getResourceGrade{}:,2:{}",resource.getResourceGrade(),GradeEnums.getAllMessage()[j]);
                        logger.info("getResourceSubject{}:,2:{}",resource.getResourceSubject(),SubjectEnums.getAllMessage()[z]);
                        if(resource.getResourceCategory().equals(CategoryEnums.getAllMessage()[i])&&resource.getResourceGrade().equals(GradeEnums.getAllMessage()[j])&&
                                resource.getResourceSubject().equals(SubjectEnums.getAllMessage()[z])){
                            ResourceDTO resourceDTO = new ResourceDTO();
                            //属性拷贝
                            BeanUtils.copyProperties(resource,resourceDTO);
                            resourceDTOList.add(resourceDTO);
                            logger.info("resourceDTOName:{}",resourceDTO.getResourceName());
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

        logger.info("result:{}",resultVO);
    }

    @Test
    public void getA(){
        List<Resource> resourceList = resourceDAO.findByResourceNameLike("java");
        Assert.assertNotNull(resourceList);
    }
}