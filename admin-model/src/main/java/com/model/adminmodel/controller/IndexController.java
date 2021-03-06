package com.model.adminmodel.controller;

import com.model.admin.AdminUserRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yrz
 */
@RequestMapping("/admin/*")
@RestController
public class IndexController {

    @Autowired
    private AdminUserRepositorty repositorty;

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
