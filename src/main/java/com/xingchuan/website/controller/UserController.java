package com.xingchuan.website.controller;

import com.xingchuan.website.constant.CommonStatusEnum;
import com.xingchuan.website.constant.DataStatusEnum;
import com.xingchuan.website.pojo.User;
import com.xingchuan.website.exception.PasswordException;
import com.xingchuan.website.message.Message;
import com.xingchuan.website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by pohoulong on 2018/1/15.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Login message.
     *
     * @param result  the result
     * @return the message
     * @throws PasswordException the password exception
     */
    @PostMapping("/user/login")
    public Message login(@RequestBody @Valid User user, BindingResult result) throws PasswordException {
        if (result.hasErrors()) {
            ObjectError error = result.getFieldError();
            return Message.error(error.getDefaultMessage());
        }
        userService.confirm(user);
        return Message.success(user.getLoginName());
    }

    /**
     * Register message.
     *
     * @param result  the result
     * @return the message
     */
    @PostMapping("/user/register")
    public Message register(@RequestBody @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            ObjectError error = result.getFieldError();
            return Message.error(error.getDefaultMessage());
        }
        userService.insert(user);
        return Message.success();
    }

    @GetMapping("/{loginName}/find")
    public Message findLoginName(@PathVariable String loginName) {
        if (loginName == null) {
            return Message.error(CommonStatusEnum._NO_DATA.getCode(),CommonStatusEnum._NO_DATA.getContent());
        }
        userService.findByLoginName(loginName);
        return Message.success();
    }

    @PostMapping("/user/update")
    public Message updateUser(@RequestBody User user,HttpSession session){
        Integer id = Integer.parseInt(session.getAttribute("userId").toString());
        user.setId(id);
        userService.update(user);
        return Message.success();
    }

    @PostMapping("/user/get")
    public Message getUser(HttpSession session){
        Integer id = Integer.parseInt(session.getAttribute("userId").toString());
        User user  = userService.selectById(id, DataStatusEnum._USE.getCode());
        return Message.success(user);
    }

    @PostMapping("/update/user")
    public Message update(@RequestBody User user){
        userService.update(user);
        return Message.success();
    }

    @PostMapping("/exit")
    public Message exit(HttpSession session){
        session.removeAttribute("loginName");
        return Message.success();
    }
}
