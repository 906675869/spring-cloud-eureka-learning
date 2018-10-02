package com.qianxp.eurekaclientdao.controller;

import com.qianxp.eurekaclientdao.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    private RedisUtils redisUtils;
    @RequestMapping("/setuser")
    public void setUserRedis(){
        redisUtils.set("user","123");
    }
    @RequestMapping("/getuser")
    @ResponseBody
    public String getUserRedis(){
        logger.info(redisUtils.get("user"));
        return redisUtils.get("user");
    }
    @Autowired
    public void setRedisUtils(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }
}
