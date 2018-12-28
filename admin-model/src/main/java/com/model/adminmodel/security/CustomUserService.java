package com.model.adminmodel.security;

import com.model.admin.AdminUserRepositorty;
import com.model.adminmodel.bean.SecurityUser;
import com.model.entitymodel.admin.AdminUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yrz
 */
@Slf4j
@Configuration
public class CustomUserService implements UserDetailsService {

    @Autowired
    private AdminUserRepositorty repositorty;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        AdminUser user = repositorty.findByUsername(s);

        if(null == user){
            throw new UsernameNotFoundException("用户不存在");
        }


        List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();

        log.info(user.getAdminRole().getRoleMark());

        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+user.getAdminRole().getRoleMark());
        //增加到权限队列中
        authorities.add(grantedAuthority);


        return new SecurityUser(user.getUsername(),user.getPassword(),authorities);
    }
}
