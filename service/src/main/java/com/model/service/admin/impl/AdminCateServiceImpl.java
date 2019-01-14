package com.model.service.admin.impl;

import com.model.entitymodel.admin.entity.AdminCate;
import com.model.service.admin.AdminCateService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yrz
 */
@Service
public class AdminCateServiceImpl implements AdminCateService {

    @Override
    public List<AdminCate> findChild(Integer parentId, List<AdminCate> list) {

        List<AdminCate> adminCateList = new ArrayList<>();

        for (AdminCate cate:list){

            if(cate.getParentId().equals(parentId)){
                cate.setList(findChild(cate.getId() , list));
                adminCateList.add(cate);
            }

        }

        return adminCateList;
    }
}
