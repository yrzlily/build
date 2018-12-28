package com.model.entitymodel.admin;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @author yrz
 */
@Entity
@Table(name = "md_admin_role")
@Data
@DynamicUpdate
public class AdminRole {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_mark")
    private String roleMark;

}
