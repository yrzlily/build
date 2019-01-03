package com.model.entitymodel.admin.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

    @NotEmpty(message = "权限名称不能为空")
    @Column(name = "role_name")
    private String roleName;

    @NotEmpty(message = "权限标识不能为空")
    @Column(name = "role_mark")
    private String roleMark;

}
