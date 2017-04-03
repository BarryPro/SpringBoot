package com.belong.controller;

import com.belong.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by belong on 2017/1/13.
 */
@Controller
public class UserController {

    @Autowired
    private IUserService service;

    @Value("${user.username}")
    private String username;


    @RequestMapping("/")
    public String index(Map map){
        map.put("username",username);
        return "index";
    }
}
