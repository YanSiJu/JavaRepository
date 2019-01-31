package com.heyong.lenrn_net.ResourceVO;
/**
 * Create By Yong
 */

import lombok.Data;

import java.util.List;


@Data
public class ResourceGradeVO {
    //资源等级（初中高中）
    private String resourceGrade;

    private List<ResourceSubjectVO> resourceSubjectVOList;
}
