package com.heyong.lenrn_net.POJO;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Create By Yong
 */
@Entity
@Data
public class Exhibition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer exhibitionId;

    private String exhibitionName;

    private Integer userId;

    private String exhibitionDescription;

    private String exhibitionContent;
}
