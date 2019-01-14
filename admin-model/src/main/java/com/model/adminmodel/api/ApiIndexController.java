package com.model.adminmodel.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yrz
 */
@RestController
@RequestMapping(value = {"/api/index", "/api"})
public class ApiIndexController {

    @RequestMapping(value = {"/index",""})
    public String index(){
        return "index";
    }

}
