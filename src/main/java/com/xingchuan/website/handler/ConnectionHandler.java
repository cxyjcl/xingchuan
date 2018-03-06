package com.xingchuan.website.handler;

import com.xingchuan.website.exception.ConnectionRefusedException;
import com.xingchuan.website.message.Message;
import com.xingchuan.website.service.impl.SmsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by pohoulong on 2018/1/16.
 */
@ControllerAdvice
public class ConnectionHandler {

    private final static Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);

    @ExceptionHandler(value = ConnectionRefusedException.class)
    @ResponseBody
    public Message ExceptionHandle(ConnectionRefusedException e) {
        logger.error("code:{},message:{}", e.getCode(), e.getMessage());
        return Message.error(e.getCode(), e.getMessage());
    }

}
