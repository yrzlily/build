package com.model.adminmodel.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yrz
 */
@RestController
@RequestMapping("/api/user")
public class ApiUserController {

    @RequestMapping("/index")
    public String index(){
        return "/user/index";
    }

}
