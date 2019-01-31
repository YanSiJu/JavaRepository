package com.heyong.lenrn_net.Service.ServiceImpl;

import com.heyong.lenrn_net.DAO.ResourceDetailsDAO;
import com.heyong.lenrn_net.POJO.ResourceDetails;
import net.sf.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Create By Yong
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceDetailsServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(ResourceDetailsServiceImplTest.class);
    @Autowired
    private ResourceDetailsDAO resourceDetailsDAO;

    @Test
    public void addDetails() {
        ResourceDetails resourceDetails = new ResourceDetails();

        HashMap<String,String> content = new HashMap<>();
        content.put("章节一","内容一");
        content.put("章节二","内容二");
        JSONObject json = JSONObject.fromObject(content);

        resourceDetails.setDetailsText(content.toString());
        resourceDetails.setResourceId(10000);
        String text = resourceDetails.getDetailsText();
        Assert.assertNotNull(resourceDetailsDAO.save(resourceDetails));
    }

    @Test
    public void getDetails(){
        ResourceDetails resourceDetails = resourceDetailsDAO.findByResourceId(10000);
        String Text = resourceDetails.getDetailsText().replaceAll("=","=\"");
        Text = Text.replaceAll(",","\",");
        Text = Text.substring(0,Text.length()-1)+"\"}";
        JSONObject json = JSONObject.fromObject(Text);
        Map<String,String> a =json;
        for(String key:a.keySet()){
            logger.info("key:{},values:{}",key,a.get(key));
        }
        logger.info("Text:{}",resourceDetails.getDetailsText());
        logger.info("Text1:{}",Text);
        Assert.assertNotNull(resourceDetails);


        Map<String,String> map = new HashMap<>();
        map.put("1","11");
        map.put("2","22");
        logger.info("map:{}",map.toString());
        String mode = "{章节一=\"内容一\",2=\"12\"}";
        JSONObject jsonObject = JSONObject.fromObject(mode);
        logger.info("json:{}",jsonObject.toString());
        Map<String,String> map2 = jsonObject;
        logger.info("map2:{}",map2.toString());
    }
}