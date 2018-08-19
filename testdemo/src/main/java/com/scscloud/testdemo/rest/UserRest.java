package com.scscloud.testdemo.rest;


import com.ace.cache.annotation.Cache;

import com.scscloud.testdemo.entity.User;
import com.scscloud.testdemo.service.UserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-06-21 8:15
 */
@RestController
@RequestMapping("api")
public class UserRest {
@Autowired
 private   UserBiz userBiz;
    //@Cache(key="permission")
    @RequestMapping(value = "/permissions", method = RequestMethod.GET)
    public @ResponseBody
    User getAllPermission(String username){
      return userBiz.getUserByUsername(username);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    String updateUser(String username){
        if(username!=null){
        throw  new RuntimeException();}
        userBiz.updateUserByUsername(username);
        return username;
    }


//    @Cache(key="permission:u{1}")
//    @RequestMapping(value = "/user/un/{username}/permissions", method = RequestMethod.GET)
//    public @ResponseBody List<PermissionInfo> getPermissionByUsername(@PathVariable("username") String username){
//        return permissionService.getPermissionByUsername(username);
//    }
//
//    @RequestMapping(value = "/user/validate", method = RequestMethod.POST)
//    public @ResponseBody UserInfo validate(@RequestBody Map<String,String> body){
//        return permissionService.validate(body.get("username"),body.get("password"));
//    }


}
