package com.model.service.admin.impl;

import com.model.admin.AdminUserRepositorty;
import com.model.entitymodel.admin.entity.AdminUser;
import com.model.entitymodel.bean.Result;
import com.model.entitymodel.utils.CryptoUtil;
import com.model.entitymodel.utils.ResultUtils;
import com.model.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 * @author yrz
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminUserRepositorty adminUserRepositorty;

    @Override
    public Result adminLogin(String username, String password) {

        AdminUser adminUser = adminUserRepositorty.findByUsername(username);

        try {

            if(null == adminUser){
                throw new Exception("用户不存在");
            }
            System.out.println(adminUser.getPassword());
            if(!BCrypt.checkpw(password, adminUser.getPassword())){
                throw new Exception("密码错误");
            }

        }catch (Exception e){
            return ResultUtils.error(e.getMessage());
        }

        return ResultUtils.success(adminUser, "登录成功");
    }
}
