package com.xingchuan.website.vo;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Administrator on 2018/1/24 0024.
 */
public class RegisterVo {

    @NotEmpty(message = "用户名不得为空")
    private String loginName;

    @NotEmpty(message = "密码不得为空")
    private String password;

    @NotEmpty(message = "真实名不得为空")
    private String realName;

    @NotEmpty(message = "验证码不得为空")
    private String code;


    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

}
