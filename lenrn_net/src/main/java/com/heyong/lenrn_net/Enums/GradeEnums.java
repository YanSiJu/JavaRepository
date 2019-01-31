package com.heyong.lenrn_net.Enums;

import lombok.Getter;

/**
 * Create By Yong
 */

@Getter
public enum GradeEnums {
    ONE(1,"基础知识"),
    TWO(2,"进阶知识"),
    THREE(3,"实例教程"),
    FOUR(4,"拓展知识"),
    END(4,"总长度数");

    private Integer code;

    private String message;

    GradeEnums(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public static String[] getAllMessage(){
        String[] Message = new String[GradeEnums.END.code];
        Message[0] = GradeEnums.ONE.message;
        Message[1] = GradeEnums.TWO.message;
        Message[2] = GradeEnums.THREE.message;
        Message[3] = GradeEnums.FOUR.message;
        return Message;
    }
}
