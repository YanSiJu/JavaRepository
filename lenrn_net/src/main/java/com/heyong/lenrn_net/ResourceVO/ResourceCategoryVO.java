package com.heyong.lenrn_net.ResourceVO;

import lombok.Data;

import java.util.List;

/**
 * Create By Yong
 */

@Data
public class ResourceCategoryVO<T> {

    /** 资源类型 **/
    private String ResourceCategory;

    private List<ResourceGradeVO> resourceGradeVOList;
}
