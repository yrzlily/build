package com.model.admin;


import com.model.entitymodel.admin.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author yrz
 */
@Repository
public interface AdminUserRepositorty extends JpaRepository<AdminUser , Integer> {

    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    AdminUser findByUsernameAndPassword(String username , String password);

    /**
     * 搜索用户
     * @param username
     * @return
     */
    AdminUser findByUsername(String username);

    /**
     * 编辑用户
     * @param username
     * @param password
     * @param roleId
     * @param id
     */
    @Transactional(rollbackOn = Exception.class)
    @Modifying
    @Query("update AdminUser as a set a.username = ?1 , a.password = ?2 , a.roleId = ?3 where a.id = ?4")
    void update(String username , String password , Integer roleId , Integer id);

    /**
     * 编辑用户
     * @param username
     * @param roleId
     * @param id
     */
    @Transactional(rollbackOn = Exception.class)
    @Modifying
    @Query("update AdminUser as a set a.username = ?1 , a.roleId = ?2 where a.id = ?3")
    void updateNoPass(String username  , Integer roleId , Integer id);
}
