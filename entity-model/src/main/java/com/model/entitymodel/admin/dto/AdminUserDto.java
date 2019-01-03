package com.model.entitymodel.admin.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author yrz
 */
@Data
public class AdminUserDto {

    private Integer id;

    private String username;

    private Date createTime;

    public AdminUserDto(Integer id, String username, Date createTime) {
        this.id = id;
        this.username = username;
        this.createTime = createTime;
    }
}
