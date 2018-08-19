package com.scscloud.testdemo.service;


import com.ace.cache.annotation.Cache;
import com.ace.cache.annotation.CacheClear;
import com.scscloud.testdemo.entity.User;
import com.scscloud.testdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-06-08 16:23
 */
@Service
//@Transactional(rollbackFor = Exception.class)
public class UserBiz  {
    @Autowired
    private UserMapper mapper;


    @CacheClear(pre="user{1.username}")
    public void updateSelectiveById(User entity) {

    }

    /**
     * 根据用户名获取用户信息
     * cache redis key 规定 服务名：key user:指定参数值
     * @param username
     * @return
     */
    @Cache(key="user{1}")
    public User getUserByUsername(String username){
        User user = new User();
        user.setUsername(username);
       return mapper.queryone(username);
    }

 /**
     * 更新用户名获取用户信息
     * @param username
     * @return
     */
    @CacheClear(pre = "user{1}")
    public User updateUserByUsername(String username){
        User user = getUserByUsername(username);
        user.setUpdTime(new Date());
        mapper.updateUser(user);
       return user ;
    }


}
