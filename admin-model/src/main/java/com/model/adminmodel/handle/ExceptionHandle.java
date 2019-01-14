package com.model.adminmodel.handle;

import com.model.entitymodel.utils.ResultUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yrz
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object handle(Exception e){

        if(e instanceof EmptyResultDataAccessException){
            EmptyResultDataAccessException dataAccessException = (EmptyResultDataAccessException) e;
            ResultUtils.error(dataAccessException.getMessage());
        }

        return ResultUtils.error(e.getMessage());
    }

}
