package com.xingchuan.website.controller;

import com.xingchuan.website.constant.CommonStatusEnum;
import com.xingchuan.website.message.Message;
import com.xingchuan.website.service.SmsService;
import com.xingchuan.website.vo.PhoneCodeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by pohoulong on 2018/3/6.
 */
@RestController
public class MessageController {

    @Autowired
    SmsService service;

    @PostMapping("/send/{phone}/message")
    public Message sendMessage(@PathVariable("phone") String phone,HttpServletResponse response,HttpServletRequest request){
        String code = service.sendMessage(phone);
        Cookie[] cookies=request.getCookies();//获取请求中的所有cookie
        if(null!=cookies) {
            for (Cookie cookie : cookies) {
                //输出cookie的标志(name)和值(value)
                if(cookie.getName().equals(phone)){
                    return Message.error(CommonStatusEnum._CODE_EXIST.getCode(),CommonStatusEnum._CODE_EXIST.getContent());
                }
            }
        }
        Cookie cookie=new Cookie("code",code);
        cookie.setMaxAge(60);
        response.addCookie(cookie);
        return Message.success(code);
    }

    @PostMapping("/code/matcher")
    public Message getMessage(@RequestBody PhoneCodeVo vo, HttpServletRequest request){
        String code = vo.getCode();
        String phone = vo.getUserPhone();
        Cookie[] cookies=request.getCookies();//获取请求中的所有cookie
        if(null!=cookies) {
            for (Cookie cookie : cookies) {
                //输出cookie的标志(name)和值(value)
                if(cookie.getName().equals(phone)){
                    String matcher = cookie.getValue();
                    service.matchCode(matcher,code);
                    return Message.success();
                }
            }
            return Message.error(CommonStatusEnum._CODE_TIME_OUT_ERROR.getCode(),CommonStatusEnum._CODE_TIME_OUT_ERROR.getContent());
        }
        else{
            return Message.error(CommonStatusEnum._CODE_TIME_OUT_ERROR.getCode(),CommonStatusEnum._CODE_TIME_OUT_ERROR.getContent());
        }
    }
}
