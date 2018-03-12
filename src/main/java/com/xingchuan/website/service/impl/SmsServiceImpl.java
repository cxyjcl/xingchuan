package com.xingchuan.website.service.impl;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.xingchuan.website.constant.CommonStatusEnum;
import com.xingchuan.website.exception.CodeErrorException;
import com.xingchuan.website.exception.OrderException;
import com.xingchuan.website.service.SmsService;
import com.xingchuan.website.util.SmsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by pohoulong on 2018/3/6.
 */
@Service
public class SmsServiceImpl implements SmsService {

    static String code = "0123456789";
    private final static Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);

    public static String createCode(int count) {
        StringBuffer generateCode = new StringBuffer();
        for (int i = 0; i < count; i++) {
            Random random = new Random();
            String tempCode = String.valueOf(code.charAt(random.nextInt(10))) + "";
            generateCode.append(tempCode);
        }
        return new String(generateCode);
    }

    @Override
    public String sendMessage(String phoneNumber) throws OrderException {
        String generateCode = createCode(4);
        SendSmsResponse response = SmsUtil.sendIdentifyingCode(phoneNumber, generateCode);
        logger.info("短信接口发送的的数据:Code: {} Message: {} RequestId: {} BizId:{}", response.getCode(),
                response.getMessage(), response.getRequestId(), response.getBizId());
        return generateCode;
    }

    @Override
    public void matchCode(String originCode, String code) throws CodeErrorException {
        if(!originCode.equals(code)){
            throw new CodeErrorException(CommonStatusEnum._CODE_ERROR.getCode(),CommonStatusEnum._CODE_ERROR.getContent());
        }
    }
}
