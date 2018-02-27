package com.xingchuan.website.service;

import com.xingchuan.website.pojo.User;
import com.xingchuan.website.exception.ConnectionRefusedException;
import com.xingchuan.website.exception.NoDataException;
import com.xingchuan.website.exception.PasswordException;
import com.xingchuan.website.exception.LoginNameRepeatException;
import org.springframework.data.domain.Page;

/**
 * Created by pohoulong on 2018/1/15.
 */
public interface UserService extends BaseService<User> {

    public Integer confirm(User user) throws PasswordException;

    public void findByLoginName(String username) throws LoginNameRepeatException;

}
