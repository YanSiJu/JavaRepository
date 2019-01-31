package com.heyong.lenrn_net.Service;

import com.heyong.lenrn_net.POJO.ResourceDetails;

import java.util.Map;

/**
 * Create By Yong
 */
public interface ResourceDetailsService {

    ResourceDetails addDetails(Map<String,String> content,Integer resourceId);

    ResourceDetails updateDetails(ResourceDetails resourceDetails);

    ResourceDetails getDetailsByResourceId(Integer resourceId);

    ResourceDetails addDetails(String content,Integer resourceId);
}