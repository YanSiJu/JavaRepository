package com.heyong.lenrn_net.DTO;/**
 * Create By Yong
 */

import lombok.Data;
import lombok.Getter;

import java.util.Date;

/**
 *
 *Create By Yong
 */

@Data
public class ResourceDTO {

    //资源编号
    private Integer resourceId;

    private String resourceAddress;
    //资源名称
    private String resourceName;

    //资源上传时间
    private Date resourceCreatetime;

    //资源下载量
    private Integer resourceDownloads;

    //上传者ID
    private Integer uploaderId;

    private String resourceImg;

    public ResourceDTO(){

    }

    public ResourceDTO(Integer resourceId, String resourceName,String resourceAddress, Date resourceCreatetime, Integer resourceDownloads, Integer uploaderId, String resourceImg) {
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.resourceAddress = resourceAddress;
        this.resourceCreatetime = resourceCreatetime;
        this.resourceDownloads = resourceDownloads;
        this.uploaderId = uploaderId;
        this.resourceImg = resourceImg;
    }

    @Override
    public String toString() {
        return "ResourceDTO{" +
                "resourceId=" + resourceId +
                ", resourceName='" + resourceName + '\'' +
                ", resourceCreatetime=" + resourceCreatetime +
                ", resourceDownloads=" + resourceDownloads +
                ", uploaderId=" + uploaderId +
                '}';
    }
}
