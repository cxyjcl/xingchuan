package com.xingchuan.website.pojo;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by pohoulong on 2018/1/14.
 */
@Entity
@DynamicUpdate(true)
@DynamicInsert(true)
public class User extends BaseEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty(message = "手机号不得为空")
    private String loginName;

    @NotEmpty(message = "密码不得为空")
    private String password;

    private String realName;

    private String production;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
    }

    public User(String loginName, String password, String realName) {
        this.loginName = loginName;
        this.password = password;
        this.realName = realName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", producter='" + production + '\'' +
                '}';
    }
}
