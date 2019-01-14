package com.model.service.admin;

import com.model.entitymodel.admin.entity.AdminCate;

import java.util.List;

/**
 * @author yrz
 */
public interface AdminCateService {

    /**
     * 递归寻找子列表
     * @param parentId
     * @param list
     * @return
     */
    List<AdminCate> findChild(Integer parentId , List<AdminCate> list);

}
