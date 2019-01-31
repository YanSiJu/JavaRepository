package com.heyong.lenrn_net.Enums;

import lombok.Getter;

/**
 * Create By Yong
 */
@Getter
public enum SexEnums {
    MAN(0,'男'),
    WOMAN(1,'女');

    private Integer code;

    private char message;

    SexEnums(Integer code, char message){
        this.code = code;
        this.message = message;
    }
}
