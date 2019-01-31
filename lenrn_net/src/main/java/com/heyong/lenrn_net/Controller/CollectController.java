package com.heyong.lenrn_net.Controller;

import com.heyong.lenrn_net.POJO.Collect;
import com.heyong.lenrn_net.Service.CollectService;
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
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    private CollectService collectService;

    Logger logger = LoggerFactory.getLogger(CollectController.class);

    @RequestMapping("/getall")
    @ResponseBody
    public List<Collect> getAllCollect(Integer userId){
        return collectService.findByuserId(userId);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    @ResponseBody
    public Collect addCollect(@RequestBody Collect collect){
        logger.info("collect:{}",collect);
        return collectService.addCollect(collect);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/delete")
    @ResponseBody
    public void deleteCollect(Integer resourceId,Integer userId){
        logger.info("resourceId:{},{}",resourceId,userId);
        collectService.delete(resourceId,userId);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/check")
    @ResponseBody
    public Collect findByResource(Integer resourceId,Integer userId){
        logger.info("resourceId:{},{}",resourceId,userId);
        return collectService.findByResourceIdAndUserId(resourceId,userId);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/fingByuserId")
    @ResponseBody
    public List<Collect> findByUserId(Integer userId){
        logger.info("userId:{}",userId);
        return collectService.findByuserId(userId);
    }

}
