package com.heyong.lenrn_net.Service.ServiceImpl;

import com.heyong.lenrn_net.DAO.ExhibitionDAO;
import com.heyong.lenrn_net.POJO.Exhibition;
import com.heyong.lenrn_net.Service.ExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create By Yong
 */
@Service
public class ExhibitionServiceImpl implements ExhibitionService {

    @Autowired
    private ExhibitionDAO exhibitionDAO;

    @Override
    public Exhibition AddExhibition(Exhibition exhibition) {
        return exhibitionDAO.save(exhibition);
    }

    @Override
    public void DeleteExhibition(Exhibition exhibition) {
        exhibitionDAO.delete(exhibition);
    }

    @Override
    public Exhibition UpdateExhibition(Exhibition exhibition) {
        return exhibitionDAO.save(exhibition);
    }

    @Override
    public List<Exhibition> findByUserId(Integer userId) {
        return exhibitionDAO.findExhibitioByUserId(userId);
    }

    @Override
    public List<Exhibition> findAll() {
        return exhibitionDAO.findAll();
    }

    @Override
    public Exhibition findById(Integer exhibitionId) {
        return exhibitionDAO.findById(exhibitionId).orElse(null);
    }
}
