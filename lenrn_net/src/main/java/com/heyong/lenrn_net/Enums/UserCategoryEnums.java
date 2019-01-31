package com.heyong.lenrn_net.Enums;

import lombok.Getter;

/**
 * Create By Yong
 */
@Getter
public enum UserCategoryEnums {
    STUDENT(0,"学生"),
    TEACHER(1,"教师");

    private Integer code;

    private String message;

    UserCategoryEnums(Integer code , String message){
        this.code = code;
        this.message = message;
    }
}
