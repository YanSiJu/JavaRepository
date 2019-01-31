package com.heyong.lenrn_net.ResourceVO;/**
 * Create By Yong
 */

import javax.xml.crypto.Data;

/**
 *
 *Create By Yong
 */

@lombok.Data
public class ResultVO<T> {

    private Integer code;

    private String message;

    private T list;
}
