package com.model.adminmodel.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.admin.AdminUserRepositorty;
import com.model.entitymodel.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author yrz
 */
@Slf4j
@WebFilter(urlPatterns = {"/admin/*"}, filterName ="adminFilter")
public class AdminFilter implements Filter {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AdminUserRepositorty adminRoleRepository;

    private String[] includeUrls = new String[]{
            "/admin/login/index",
            "/admin/login/needLogin"
    };

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter 初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String uri = request.getRequestURI();
        boolean needFilter = isNeedFilter(uri);
        log.info(uri);
        HttpSession session = request.getSession();

        if (!needFilter) {
            filterChain.doFilter(servletRequest, servletResponse);
            log.info("无需过滤");
        }else{
            log.info("过滤");

            String userSession = "adminUser";
            if(session.getAttribute(userSession) == null){
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write(objectMapper.writeValueAsString(ResultUtils.error("请登录")));
            }else{
                filterChain.doFilter(servletRequest, servletResponse);
            }

        }

    }

    @Override
    public void destroy() {
        log.info("filter 销毁");
    }

    private boolean isNeedFilter(String uri) {
        for (String includeUrl : includeUrls) {
            if(includeUrl.equals(uri)) {
                return false;
            }
        }
        return true;
    }


}
