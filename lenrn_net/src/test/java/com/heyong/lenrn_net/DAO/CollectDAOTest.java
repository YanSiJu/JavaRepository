package com.heyong.lenrn_net.DAO;

import com.heyong.lenrn_net.POJO.Collect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Create By Yong
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectDAOTest {

    @Autowired
    private CollectDAO dao;

    @Test
    public void findByResourceIdAndUserId() {
        Collect collect = dao.findByResourceIdAndUserId(10000,10001);
        collect.getCollectName();
    }

    @Test
    public void delete(){
        dao.deleteByResourceIdAndUserId(10000,10000);
    }
}