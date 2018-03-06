package com.xingchuan.website.service;

import com.xingchuan.website.exception.NoDataException;
import com.xingchuan.website.exception.OrderException;

/**
 * Created by pohoulong on 2018/3/6.
 */
public interface SmsService {

    public String sendMessage(String phoneNumber) throws OrderException;

    public void matchCode(String originCode,String code) throws NoDataException;
}
