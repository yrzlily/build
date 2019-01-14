//package com.model.adminmodel.security;
//
//import com.model.adminmodel.security.handle.api.FailureHandle;
//import com.model.adminmodel.security.handle.api.LogoutHandle;
//import com.model.adminmodel.security.handle.api.SuccessHandle;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
///**
// * @author yrz
// */
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    /**
//     * 自定义认证
//     */
//    @Autowired
//    private CustomUserService customUserService;
//
//    /**
//     * 自定义登录成功跳转
//     */
//    @Autowired
//    private SuccessHandle successHandle;
//
//    /**
//     * 自定义登录失败跳转
//     */
//    @Autowired
//    private FailureHandle failureHandle;
//
//    @Autowired
//    private LogoutHandle logoutHandle;
//
//    @Autowired
//    private UnauthorizedEntryPoint unauthorizedEntryPoint;
//
//    /**
//     * 认证配置
//     * @param http
//     * @throws Exception
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                .csrf().disable()
//                .exceptionHandling().authenticationEntryPoint(new MyLoginUrlAuthenticationEntryPoint("/login/index"))
//                .and()
//                .authorizeRequests()
//                .antMatchers( "/index").permitAll()
//                .antMatchers("/admin/**").hasAnyRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login/index")
//                .successHandler(successHandle)
//                .failureHandler(failureHandle)
//                .permitAll()
//                .and()
//                .logout()
//                .logoutSuccessHandler(logoutHandle)
//                .permitAll()
//                .and()
//                .rememberMe()
//                .tokenValiditySeconds(3000000);
//    }
//
//
//    /**
//     * 明文加密
//     * @return
//     */
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider
//                = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(customUserService);
//        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
//        return authProvider;
//    }
//
//
//
//}
