package com.xingchuan.website.handler;

import com.xingchuan.website.exception.LoginNameRepeatException;
import com.xingchuan.website.exception.PasswordException;
import com.xingchuan.website.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by pohoulong on 2018/1/15.
 */
@ControllerAdvice
public class UserHandler {

    private final static Logger logger = LoggerFactory.getLogger(UserHandler.class);

    @ExceptionHandler(value = PasswordException.class)
    @ResponseBody
    public Message handle(PasswordException e) {
        logger.error("code:{},message:{}", e.getCode(), e.getMessage());
        return Message.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = LoginNameRepeatException.class)
    @ResponseBody
    public Message handle(LoginNameRepeatException e) {
        logger.error("code:{},message:{}", e.getCode(), e.getMessage());
        return Message.error(e.getCode(), e.getMessage());
    }
}
