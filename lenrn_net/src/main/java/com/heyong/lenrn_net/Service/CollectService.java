package com.heyong.lenrn_net.Service;

import com.heyong.lenrn_net.POJO.Collect;

import java.util.List;

/**
 * Create By Yong
 */
public interface CollectService {

    /**
     * 查询当前用户所收藏的资源
     */
    List<Collect> findByuserId(Integer userId);

    Collect addCollect(Collect collect);

    void deleteCollectByResourceIdAndUserId(Integer resourceId,Integer userId);

    Collect findByResourceIdAndUserId(Integer resourceId,Integer userId);

    void delete(Integer resourceId,Integer userId);
}
