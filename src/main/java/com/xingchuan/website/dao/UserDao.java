package com.xingchuan.website.dao;

import com.xingchuan.website.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pohoulong on 2018/1/12.
 */

public interface UserDao extends JpaRepository<User, Integer> {

    User findByLoginNameAndPassword(String loginName, String Password);

    User findByLoginName(String loginName);

    Page<User> findByRealName(String realName, Pageable page);
}