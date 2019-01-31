package com.heyong.lenrn_net.Service.ServiceImpl;

import com.heyong.lenrn_net.POJO.Exhibition;
import com.heyong.lenrn_net.Service.ExhibitionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Create By Yong
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExhibitionServiceImplTest {

    @Autowired
    private ExhibitionService service;

    @Test
    public void addExhibition() {
        Exhibition exhibition = new Exhibition();
        exhibition.setUserId(10001);
        exhibition.setExhibitionName("Java学习网");
        exhibition.setExhibitionDescription("一个关于学习Java基础的平台系统");
        exhibition.setExhibitionContent("努力学习天天向上");
        service.AddExhibition(exhibition);
    }

    @Test
    public void deleteExhibition() {
        Exhibition exhibition = new Exhibition();
        exhibition.setExhibitionId(10001);
        exhibition.setUserId(10001);
        exhibition.setExhibitionName("Java学习网");
        exhibition.setExhibitionDescription("一个关于学习Java基础的平台系统");
        exhibition.setExhibitionContent("努力学习天天向上");
        service.DeleteExhibition(exhibition);
    }

    @Test
    public void updateExhibition() {
    }

    @Test
    public void findByUserId() {
        List<Exhibition> list = service.findByUserId(10000);
        list.size();
    }
}