//package com.model.adminmodel.security;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
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
//@Slf4j
//public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {
//    @Override
//    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
//
//        if(httpServletRequest.getRequestURI().contains("admin")){
//            log.info("admin");
//            httpServletResponse.sendRedirect("/admin/login/index");
//        }else{
//            log.info("index");
//            httpServletResponse.sendRedirect("/login/index");
//        }
//    }
//}
