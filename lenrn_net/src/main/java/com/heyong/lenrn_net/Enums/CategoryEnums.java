package com.heyong.lenrn_net.Enums;

import lombok.Getter;

/**
 * Create By Yong
 */

@Getter
public enum CategoryEnums {
    DOCUMENT(0,"文档"),
    VIDEO(1,"视频");

    private Integer code;

    private String message;

    CategoryEnums(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public static String[] getAllMessage(){
        String[] Message = new String[2];
        Message[0] = CategoryEnums.DOCUMENT.getMessage();
        Message[1] = CategoryEnums.VIDEO.getMessage();
        return Message;
    }

}
