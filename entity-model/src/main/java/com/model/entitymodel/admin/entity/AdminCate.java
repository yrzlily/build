package com.model.entitymodel.admin.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author yrz
 */
@Entity
@Table(name = "md_admin_cate")
@Data
public class AdminCate {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "admin_cate_name")
    private String cateName;

    @Column(name = "parent_id")
    private Integer parentId;

    private Integer sort;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Transient
    private List<AdminCate> list;
}
