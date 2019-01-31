package com.heyong.lenrn_net.Controller;

import com.heyong.lenrn_net.DTO.DetailsDTO;
import com.heyong.lenrn_net.POJO.Resource;
import com.heyong.lenrn_net.POJO.ResourceDetails;
import com.heyong.lenrn_net.Service.ResourceDetailsService;
import com.heyong.lenrn_net.Utils.ToJsonString;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Create By Yong
 */

@Controller
@RequestMapping("/details")
public class DetailsController {

    private Logger logger = LoggerFactory.getLogger(DetailsController.class);

    @Autowired
    private ResourceDetailsService detailsService;

    @PostMapping("/add")
    @ResponseBody
    public ResourceDetails add(@RequestParam("text") String text, @RequestParam("resourceId") Integer resourceId){
        String Text = ToJsonString.ToJSONString(text);
        Map<String,String> map = JSONObject.fromObject(Text);
        return detailsService.addDetails(map,resourceId);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getDetails")
    @ResponseBody
    public String getContent(Integer resourceId){
        logger.info("resourceId:{}",resourceId);
        DetailsDTO detailsDTO = new DetailsDTO();
        ResourceDetails resourceDetails = detailsService.getDetailsByResourceId(resourceId);
        logger.info("text:{}",resourceDetails.getDetailsText());
        BeanUtils.copyProperties(resourceDetails,detailsDTO);
        Map<String,String> map = JSONObject.fromObject(resourceDetails.getDetailsText());
        logger.info("text:{}",resourceDetails.getDetailsText());
        detailsDTO.setText(map);
        logger.info(resourceDetails.getDetailsText());
        return resourceDetails.getDetailsText();
    }
}
