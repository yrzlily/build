package com.model.entitymodel.admin.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author yrz
 */
@Entity
@Data
@Table(name = "md_admin_user")
@DynamicUpdate
public class AdminUser {

    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    private String password;

    @Column(name = "role_id")
    private Integer roleId;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id",insertable = false, updatable = false)
    private AdminRole adminRole;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    private Date createTime;

}
