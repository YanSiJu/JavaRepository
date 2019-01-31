package com.heyong.lenrn_net.Controller;

import com.heyong.lenrn_net.POJO.Exhibition;
import com.heyong.lenrn_net.Service.ExhibitionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create By Yong
 */
@RestController
@RequestMapping("/exhibition")
public class ExhibitionController {

    Logger logger = LoggerFactory.getLogger(ExhibitionController.class);

    @Autowired
    private ExhibitionService exhibitionService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Exhibition AddExhibition(@RequestBody Exhibition exhibition){
        return exhibitionService.AddExhibition(exhibition);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/delete")
    public void Delete(@RequestBody Exhibition exhibition){
        exhibitionService.DeleteExhibition(exhibition);
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/update")
    @ResponseBody
    public Exhibition UpdateExhibition(@RequestBody Exhibition exhibition){
        logger.info("exhibition:{}",exhibition);
        return exhibitionService.UpdateExhibition(exhibition);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/getByuserId")
    public List<Exhibition> GetByUserId(Integer userId){
        logger.info("userId:{}",userId);
        return exhibitionService.findByUserId(userId);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/getAll")
    public List<Exhibition> findAll(){
        return exhibitionService.findAll();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/getById")
    public Exhibition findByEchibitionId(Integer exhibitionId){
        return exhibitionService.findById(exhibitionId);
    }
}







