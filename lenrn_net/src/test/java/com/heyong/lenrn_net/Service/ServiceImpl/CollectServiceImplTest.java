package com.heyong.lenrn_net.Service.ServiceImpl;

import com.heyong.lenrn_net.DAO.CollectDAO;
import com.heyong.lenrn_net.POJO.Collect;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Create By Yong
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectServiceImplTest {

    @Autowired
    private CollectDAO collectDAO;

    @Test
    public void findByuserId() {
        List<Collect> list = collectDAO.findCollectsByUserId(10000);
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void addCollect() {
        Collect collect = new Collect();

        collect.setCollectName("数学看一");
        collect.setResourceId(10001);
        collect.setUserId(10000);

        collectDAO.save(collect);
    }

    @Test
    public void deleteCollect() {
            Collect collect = collectDAO.findById(10001).orElse(null);
            collectDAO.delete(collect);
    }
}