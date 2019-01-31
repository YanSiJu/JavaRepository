package com.heyong.lenrn_net.Exception;

/**自定义异常类
 * Create By Yong
 */


public class lenrnException extends RuntimeException{

    private Integer code;

    public lenrnException(String message,Integer code){
        super(message);

        this.code = code;
    }
}
