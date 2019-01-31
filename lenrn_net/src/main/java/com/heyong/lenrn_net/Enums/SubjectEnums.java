package com.heyong.lenrn_net.Enums;


import lombok.Getter;

/**
 * Create By Yong
 */
@Getter
public enum SubjectEnums {
    JAVAEE(1,"JavaEE"),
    JAVASE(2,"JavaSE"),
    WEB(3,"WEB前端编程"),
    PYTHON(4,"Python编程"),
    PHP(5,"PHP编程");

    private Integer code;

    private String message;

    SubjectEnums(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    public static String[] getAllMessage(){
        String[] Message = new String[5];
        Message[0] = SubjectEnums.JAVAEE.getMessage();
        Message[1] = SubjectEnums.JAVASE.getMessage();
        Message[2] = SubjectEnums.WEB.getMessage();
        Message[3] =SubjectEnums.PYTHON.getMessage();
        Message[4] = SubjectEnums.PHP.getMessage();
        return Message;
    }

}
