package com.heyong.lenrn_net.Service.ServiceImpl;

/**
 * Create By Yong
 */

import com.heyong.lenrn_net.DAO.ResourceDetailsDAO;
import com.heyong.lenrn_net.POJO.ResourceDetails;
import com.heyong.lenrn_net.Service.ResourceDetailsService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ResourceDetailsServiceImpl implements ResourceDetailsService {

    private Logger logger = LoggerFactory.getLogger(ResourceDetailsServiceImpl.class);

    @Autowired
    private ResourceDetailsDAO resourceDetailsDAO;

    @Override
    public ResourceDetails addDetails(Map<String,String> content, Integer resourceId) {
        ResourceDetails resourceDetails = new ResourceDetails();

        //map转JSONObject
        JSONObject json = JSONObject.fromObject(content);
        resourceDetails.setDetailsText(json.toString());
        resourceDetails.setResourceId(resourceId);


        return resourceDetailsDAO.save(resourceDetails);
    }

    @Override
    public ResourceDetails updateDetails(ResourceDetails resourceDetails) {
        return resourceDetailsDAO.save(resourceDetails);
    }

    @Override
    public ResourceDetails getDetailsByResourceId(Integer resourceId) {
        return resourceDetailsDAO.findByResourceId(resourceId);
    }

    @Override
    public ResourceDetails addDetails(String content, Integer resourceId) {
        content = content.replaceAll(":","\":\"");
        content = content.replaceAll(",","\",\"");
        content = "{\"" + content + "\"}";
        logger.info("content:{}",content);
        ResourceDetails resourceDetails = new ResourceDetails();
        resourceDetails.setResourceId(resourceId);
        resourceDetails.setDetailsText(content);
        return resourceDetailsDAO.save(resourceDetails);
    }
}
