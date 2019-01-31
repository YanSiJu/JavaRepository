package com.heyong.lenrn_net.DAO;

import com.heyong.lenrn_net.POJO.Exhibition;
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
public class ExhibitionDAOTest {

    @Autowired
    private ExhibitionDAO dao;

    @Test
    public void findExhibitioByByUserId() {
        List<Exhibition> list = dao.findExhibitioByUserId(10000);
        list.size();
    }
}