package com.model.adminmodel.controller;

import com.model.admin.AdminRoleRepository;
import com.model.adminmodel.bean.Result;
import com.model.adminmodel.utils.ResultUtils;
import com.model.entitymodel.admin.entity.AdminRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

/**
 * @author yrz
 */
@RestController
@RequestMapping("/admin/role/*")
public class AdminRoleController {

    @Autowired
    private AdminRoleRepository repository;

    /**
     * 查询
     * @return
     */
    @GetMapping("/index")
    public Result index(){
        return ResultUtils.success(repository.findAll(),"读取成功");
    }

    @GetMapping("/find/{id}")
    public Result find(@PathVariable("id")Integer id){
        return ResultUtils.success(repository.findById(id).get(),"读取成功");
    }

    @PostMapping("/add")
    public Result add(@Valid AdminRole adminRole , BindingResult result){

        if(result.hasErrors()){
            return ResultUtils.error(Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
        }
        System.out.println(adminRole);
        repository.save(adminRole);

        return ResultUtils.success(adminRole , "添加成功");
    }
}
