package com.xingchuan.website.exception;

/**
 * Created by pohoulong on 2018/3/6.
 */
public class CodeTimeOutException extends RuntimeException {
    private Integer code;

    private String message;

    public CodeTimeOutException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
