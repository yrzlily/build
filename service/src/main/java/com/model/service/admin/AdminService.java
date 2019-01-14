package com.model.service.admin;

import com.model.entitymodel.bean.Result;
import org.springframework.stereotype.Service;

/**
 * @author yrz
 */
public interface AdminService {

    /**
     * 登录认证
     * @param username
     * @param password
     * @return
     */
    Result adminLogin(String username, String password);

}
