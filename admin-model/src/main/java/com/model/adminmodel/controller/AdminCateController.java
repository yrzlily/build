package com.model.adminmodel.controller;

import com.model.admin.AdminCateRepository;
import com.model.adminmodel.bean.Result;
import com.model.adminmodel.utils.ResultUtils;
import com.model.entitymodel.admin.entity.AdminCate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Objects;

/**
 * @author yrz
 */
@RestController
@RequestMapping("/admin/cate")
public class AdminCateController {

    @Autowired
    private AdminCateRepository repository;

    @GetMapping("/index")
    public Result index(){
        return ResultUtils.success(repository.findAll() , "读取成功");
    }

    @PostMapping("/add")
    public Result add(@Valid AdminCate adminCate , BindingResult result){
        if(result.hasErrors()){
            return ResultUtils.error(Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
        }

        repository.save(adminCate);

        return ResultUtils.success(adminCate , "添加成功");
    }
}
