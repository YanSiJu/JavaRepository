package com.heyong.lenrn_net.Controller;

import com.heyong.lenrn_net.DTO.ResourceDTO;
import com.heyong.lenrn_net.DTO.ResourceUploadDTO;
import com.heyong.lenrn_net.POJO.Resource;
import com.heyong.lenrn_net.ResourceVO.ResultVO;
import com.heyong.lenrn_net.Service.ResourceService;
import com.heyong.lenrn_net.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create By Yong
 */

@Controller
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private UserService userService;

    private static Logger logger = LoggerFactory.getLogger(ResourceController.class);

    @CrossOrigin(origins = "*")
    @ResponseBody
    @GetMapping("/getall")
    public ResultVO getall(){
        return resourceService.findAll();
    }

    @CrossOrigin(origins = "*")
    @ResponseBody
    @GetMapping("/getallResource")
    public List<Resource> getallResource()
    {
        return resourceService.getAll();
    }

    @CrossOrigin(origins = "*")
    @ResponseBody
    @GetMapping("/getById")
    public Resource getById(Integer resourceId){
        return resourceService.findById(resourceId);
    }


    @ResponseBody
    @PostMapping("/add")
    public Resource addResource(Resource resource){
        return resourceService.addResource(resource);
    }

    @CrossOrigin(origins = "*")
    @ResponseBody
    @PostMapping("/getByUploadId")
    public List<ResourceUploadDTO> getByUploadId( @RequestParam("uploaderId") Integer uploaderId){
        return  resourceService.findResourcesByUploadId(uploaderId);
    }

    @CrossOrigin(origins = "*")
    @ResponseBody
    @GetMapping("/getByUserName")
    public List<ResourceUploadDTO> getByUserName(String username){
        logger.info("userName:{}",username);
        Integer userId = userService.findUserByUserName(username).getUserId();
        logger.info("useId:{}",userId);
        return  resourceService.findResourcesByUploadId(userId);
    }


    @ResponseBody
    @RequestMapping(value ="/getBySubject")
    public ResultVO getBySubject(String subject){
        logger.info("subject:{}",subject);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMessage("success!!");
        resultVO.setList(resourceService.findResourceByResourceSubject(subject));
        return resultVO;

    }

    @CrossOrigin(origins = "*")
    @ResponseBody
    @RequestMapping(value = "/getBySubjectAndGrade")
    public ResultVO getBySubjectAndGrade(@RequestParam("subject") String subject,@RequestParam(value = "grade",defaultValue = "all",required = false) String grade){
        logger.info("why++subject:{}||grade:{}",subject,grade);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMessage("success!");
        resultVO.setList(resourceService.findByResourceSubjectAndGrade(subject,grade));
        return resultVO;
    }


    //搜索模块
    @CrossOrigin(origins = "*")
    @ResponseBody
    @RequestMapping(value = "/getByResourceName")
    public List<ResourceDTO> getResource(String resourceName){
        logger.info("resourceName:{}",resourceName);
        return resourceService.findByResourceNameLike(resourceName);
    }

    //删除资源
    @CrossOrigin(origins = "*")
    @ResponseBody
    @PostMapping(value = "/deleteResource")
    public void deleteResource(@RequestBody Resource resource){
        logger.info("resourceId:{}",resource.getResourceId());
        Resource resource1 = resourceService.findById(resource.getResourceId());
        resourceService.deleteResource(resource1);
    }

    @CrossOrigin(origins = "*")
    @ResponseBody
    @PostMapping(value = "/updataResource")
    public Resource updateResource(@RequestBody Resource resource){
        logger.info("resource:{}",resource);
        return resourceService.updateResource(resource);
    }

}





