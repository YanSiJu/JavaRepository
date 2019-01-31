package com.heyong.lenrn_net.POJO;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Create By Yong
 */

@Entity
@DynamicUpdate
@Data
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //资源编号
    private Integer resourceId;

    //资源名称
    private String resourceName;

    //资源存放地址
    private String resourceAddress;

    //资源类别（视频或者文档）
    private String resourceCategory;

    //资源学科 （语文数学...）
    private String resourceSubject;

    //资源等级（初中高中）
    private String resourceGrade;

    //资源上传时间
    private Date resourceCreatetime;

    //资源下载量
    private Integer resourceDownloads = 0;

    //上传者ID
    private Integer uploaderId;

    private String resourceImg;

    @Override
    public String toString() {
        return "Resource{" +
                "resourceId=" + resourceId +
                ", resourceName='" + resourceName + '\'' +
                ", resourceAddress='" + resourceAddress + '\'' +
                ", resourceCategory='" + resourceCategory + '\'' +
                ", resourceSubject='" + resourceSubject + '\'' +
                ", resourceGrade='" + resourceGrade + '\'' +
                ", resourceCreatetime=" + resourceCreatetime +
                ", resourceDownloads=" + resourceDownloads +
                ", uploaderId=" + uploaderId +
                ". resourceImg=" + resourceImg +
                '}';
    }
}







