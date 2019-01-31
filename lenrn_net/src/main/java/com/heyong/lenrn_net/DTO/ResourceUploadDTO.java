package com.heyong.lenrn_net.DTO;

import lombok.Data;

import java.util.Date;

/**
 * Create By Yong
 */

@Data
public class ResourceUploadDTO {
    //资源编号
    private Integer resourceId;

    //资源名称
    private String resourceName;

    //资源种类
    private String resourceCategory;

    //资源学科 （语文数学...）
    private String resourceSubject;

    //资源等级（初中高中）
    private String resourceGrade;

    //资源上传时间
    private Date resourceCreatetime;

    //资源下载量
    private Integer resourceDownloads;


    public ResourceUploadDTO(Integer resourceId, String resourceName, String resourceCategory, String resourceSubject,
                             String resourceGrade, Date resourceCreatetime, Integer resourceDownloads) {
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.resourceCategory = resourceCategory;
        this.resourceSubject = resourceSubject;
        this.resourceGrade = resourceGrade;
        this.resourceCreatetime = resourceCreatetime;
        this.resourceDownloads = resourceDownloads;
    }
}
