package com.model.adminmodel.admin;

import com.model.admin.AdminUserRepositorty;
import com.model.entitymodel.bean.Result;
import com.model.entitymodel.utils.ResultUtils;
import com.model.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yrz
 */
@RestController
@RequestMapping("/admin/login/*")
public class AdminLoginController {

    @Autowired
    private AdminUserRepositorty adminUserRepositorty;

    @Autowired
    private AdminService adminService;

    @RequestMapping("/index")
    public Result index(@RequestParam("username")String username, @RequestParam("username")String password){

        return adminService.adminLogin(username, password);
    }

    public Result success(){
        return ResultUtils.success(null , "登录成功");
    }

}
