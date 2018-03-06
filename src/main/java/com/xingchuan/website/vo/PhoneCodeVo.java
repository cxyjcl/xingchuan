package com.xingchuan.website.vo;

import org.springframework.stereotype.Component;

/**
 * Created by pohoulong on 2018/3/6.
 */
@Component
public class PhoneCodeVo {

    private String userPhone;

    private String code;

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "PhoneCodeVo{" +
                "userPhone='" + userPhone + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
