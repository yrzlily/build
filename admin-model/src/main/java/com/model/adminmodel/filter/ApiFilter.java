package com.model.adminmodel.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author yrz
 */
@Slf4j
@javax.servlet.annotation.WebFilter(urlPatterns = {"/api/*"}, filterName = "apiFilter")
@Order(1)
public class ApiFilter implements Filter {

    private static String userSession = "user";

    @Autowired
    private ObjectMapper objectMapper;

    private String[] includeUrls = new String[]{
            "/api/login/index",
            "/api/login/needLogin"
    };

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("过滤");
        filterChain.doFilter(servletRequest , servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter 初始化");
    }

    @Override
    public void destroy() {
        log.info("filter 销毁");
    }
}
