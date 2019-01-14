package com.model.adminmodel.admin;

import com.model.admin.AdminCateRepository;
import com.model.entitymodel.bean.Result;
import com.model.entitymodel.utils.ResultUtils;
import com.model.entitymodel.admin.entity.AdminCate;
import com.model.service.admin.AdminCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private AdminCateService adminCateService;

    @GetMapping("/index")
    public Result index(){
        return ResultUtils.success(repository.findAll() , "读取成功");
    }

    /**
     * 添加
     * @param adminCate
     * @param result
     * @return
     */
    @PostMapping("/add")
    public Result add(@Valid AdminCate adminCate , BindingResult result){
        if(result.hasErrors()){
            return ResultUtils.error(Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
        }

        repository.save(adminCate);

        return ResultUtils.success(adminCate , "添加成功");
    }

    /**
     * 编辑
     * @param adminCate
     * @param result
     * @return
     */
    @PutMapping("/edit")
    public Result edit(@Valid AdminCate adminCate , BindingResult result){
        if(result.hasErrors()){
            return ResultUtils.error(Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
        }
        adminCate.setId(adminCate.getId());
        repository.save(adminCate);
        return ResultUtils.success(adminCate , "编辑成功");
    }

    @GetMapping("/navList")
    public Result findChild(){
        return ResultUtils.success(adminCateService.findChild(0 , repository.findAll()) , "读取成功");
    }
}
