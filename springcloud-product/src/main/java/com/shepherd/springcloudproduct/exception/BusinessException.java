package com.shepherd.springcloudproduct.exception;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2020/4/19 0:03
 */
public class BusinessException extends RuntimeException{

    private Integer code;

    public BusinessException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public BusinessException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }


}