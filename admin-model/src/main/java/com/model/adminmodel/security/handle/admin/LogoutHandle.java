//package com.model.adminmodel.security.handle.admin;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.model.entitymodel.utils.ResultUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.logout.LogoutHandler;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author yrz
// */
//@Configuration
//public class LogoutHandle implements LogoutSuccessHandler {
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//
//    @Override
//    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//        httpServletResponse.setContentType("application/json;charset=UTF-8");
//        try {
//            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(ResultUtils.success(authentication , "登出成功")));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
