package com.heyong.lenrn_net.DTO;

import lombok.Data;

import java.util.Map;

/**
 * Create By Yong
 */

@Data
public class DetailsDTO {
    private Integer detailsId;

    private Map<String,String> Text;

    private Integer resourceId;
}
