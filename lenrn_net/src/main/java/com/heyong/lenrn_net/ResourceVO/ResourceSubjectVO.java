package com.heyong.lenrn_net.ResourceVO;/**
 * Create By Yong
 */

import com.heyong.lenrn_net.DTO.ResourceDTO;
import lombok.Data;

import java.util.Date;
import java.util.List;
/**
 *
 *Create By Yong
 */

@Data
public class ResourceSubjectVO {

    //资源学科 （语文数学...）
    private String resourceSubject;

    private List<ResourceDTO> resourceDTOList;
}
