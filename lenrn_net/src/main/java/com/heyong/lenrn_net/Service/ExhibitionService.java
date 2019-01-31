package com.heyong.lenrn_net.Service;

import com.heyong.lenrn_net.POJO.Exhibition;

import java.util.List;

/**
 * Create By Yong
 */
public interface ExhibitionService {

    //增加展览
    public Exhibition AddExhibition(Exhibition exhibition);

    //删除展览
    public void DeleteExhibition(Exhibition exhibition);

    //修改展览
    public Exhibition UpdateExhibition(Exhibition exhibition);

    //通过用户ID查询展览
    public List<Exhibition> findByUserId(Integer userId);

    //查询所有Exhibition
    public List<Exhibition> findAll();

    public Exhibition findById(Integer exhibitionId);
}
