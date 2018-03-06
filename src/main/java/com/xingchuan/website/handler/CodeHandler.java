package com.xingchuan.website.handler;

import com.xingchuan.website.exception.CodeErrorException;
import com.xingchuan.website.exception.OrderException;
import com.xingchuan.website.message.Message;
import com.xingchuan.website.service.impl.SmsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by pohoulong on 2018/3/6.
 */
public class CodeHandler {

    private final static Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);

    @ExceptionHandler(value = OrderException.class)
    @ResponseBody
    public Message handle(OrderException e) {
        logger.error("code:{},message:{}", e.getCode(), e.getMessage());
        return Message.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = CodeErrorException.class)
    @ResponseBody
    public Message handle(CodeErrorException e) {
        logger.error("code:{},message:{}", e.getCode(), e.getMessage());
        return Message.error(e.getCode(), e.getMessage());
    }


}
