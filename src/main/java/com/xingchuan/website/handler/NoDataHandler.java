package com.xingchuan.website.handler;

import com.xingchuan.website.exception.NoDataException;
import com.xingchuan.website.message.Message;
import com.xingchuan.website.service.impl.SmsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by pohoulong on 2018/1/15.
 */
@ControllerAdvice
public class NoDataHandler {

    private final static Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);

    @ExceptionHandler(value = NoDataException.class)
    @ResponseBody
    public Message handle(NoDataException e) {
        logger.error("code:{},message:{}", e.getCode(), e.getMessage());
        return Message.error(e.getCode(), e.getMessage());
    }
}
