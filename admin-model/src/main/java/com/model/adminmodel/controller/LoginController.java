package com.model.adminmodel.controller;

import com.model.adminmodel.bean.Result;
import com.model.adminmodel.utils.ResultUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yrz
 */
@RestController
@RequestMapping("/admin/login/*")
public class LoginController {

    @RequestMapping("/index")
    public String index(){

        return "/admin/login";
    }

    public Result success(){
        return ResultUtils.success(null , "登录成功");
    }

}
