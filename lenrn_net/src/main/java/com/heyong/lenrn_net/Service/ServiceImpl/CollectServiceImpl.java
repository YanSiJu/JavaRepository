package com.heyong.lenrn_net.Service.ServiceImpl;
/**
 * Create By Yong
 */

import com.heyong.lenrn_net.DAO.CollectDAO;
import com.heyong.lenrn_net.POJO.Collect;
import com.heyong.lenrn_net.Service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectDAO collectDAO;

    @Override
    public List<Collect> findByuserId(Integer userId) {
        return collectDAO.findCollectsByUserId(userId);
    }

    @Override
    public Collect addCollect(Collect collect) {
        return collectDAO.save(collect);
    }

    @Override
    public void deleteCollectByResourceIdAndUserId(Integer resourceId,Integer userId) {
        collectDAO.deleteByResourceIdAndUserId(resourceId,userId);
    }

    @Override
    public Collect findByResourceIdAndUserId(Integer resourceId,Integer userId) {
        return collectDAO.findByResourceIdAndUserId(resourceId,userId);
    }

    @Override
    public void delete(Integer resourceId, Integer userId) {
        collectDAO.delete(collectDAO.findByResourceIdAndUserId(resourceId,userId));
    }
}
