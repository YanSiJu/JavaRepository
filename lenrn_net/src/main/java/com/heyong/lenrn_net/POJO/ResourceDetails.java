package com.heyong.lenrn_net.POJO;
/**
 * Create By Yong
 */

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class ResourceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detailsId;

    private String detailsText;

    private Integer resourceId;
}

