package com.model.adminmodel.admin;

import com.model.admin.AdminUserRepositorty;
import com.model.entitymodel.bean.Result;
import com.model.entitymodel.utils.ResultUtils;
import com.model.entitymodel.admin.dto.AdminUserDto;
import com.model.entitymodel.admin.entity.AdminUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * @author yrz
 */
@RestController
@Slf4j
@RequestMapping("/admin/user/*")
public class AdminUserController {

    @Autowired
    private AdminUserRepositorty repositorty;

    @RequestMapping("/index")
    public List<AdminUser> index(){
        return repositorty.findAll();
    }

    /**
     * 查询单个用户
     * @param id
     * @return
     */
    @GetMapping("/find/{id}")
    public AdminUserDto find(@PathVariable("id")Integer id){
        return repositorty.findSome(id);
    }

    /**
     * 添加用户
     * @param adminUser
     * @param result
     * @return
     */
    @PostMapping("/add")
    public Result add(@Valid AdminUser adminUser , BindingResult result){

        if(result.hasErrors()){
            return ResultUtils.error(Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
        }

        try {
            if(null != repositorty.findByUsername(adminUser.getUsername())){
                throw new Exception("用户名已被注册");
            }
            adminUser.setPassword(BCrypt.hashpw(adminUser.getPassword(),BCrypt.gensalt()));
        }catch (Exception e){
            return ResultUtils.error(e.getMessage());
        }

        repositorty.save(adminUser);
        return ResultUtils.success(adminUser,"添加成功");
    }

    /**
     * 编辑管理员
     * @param adminUser
     * @param result
     * @return
     */
    @Transactional(rollbackOn = DataAccessException.class)
    @PutMapping("/edit")
    public Result edit(@Valid AdminUser adminUser , BindingResult result){

        if(result.hasErrors()){
            return ResultUtils.error(Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
        }

        try {
            if(null == adminUser.getPassword()){
                repositorty.updateNoPass(adminUser.getUsername() , adminUser.getRoleId() , adminUser.getId());
            }else{
                adminUser.setPassword(BCrypt.hashpw(adminUser.getPassword(),BCrypt.gensalt()));
                repositorty.update(adminUser.getUsername() , adminUser.getPassword() , adminUser.getRoleId() , adminUser.getId());
            }

        }catch (DataAccessException e){
            return ResultUtils.error(e.getMessage());
        }

        return ResultUtils.success(adminUser,"编辑成功");
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    @Transactional(rollbackOn = EmptyResultDataAccessException.class)
    public Result delete(@PathVariable("id")Integer id ){

        try {
            repositorty.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            return ResultUtils.error(e.getMessage());
        }

        return ResultUtils.success(id,"删除成功");
    }
}
