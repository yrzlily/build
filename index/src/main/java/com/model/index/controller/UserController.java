package com.model.index.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yrz
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/index")
    public String index(){
        return "/user";
    }

}
