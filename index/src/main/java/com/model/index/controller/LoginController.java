package com.model.index.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yrz
 */
@RestController
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

}
