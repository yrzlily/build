package com.model.adminmodel.utils;

import com.model.adminmodel.bean.Result;

/**
 * @author yrz
 */
public class ResultUtils {

    /**
     * 请求成功返回
     * @param data
     * @return
     */
    public static Result success(Object data , String msg){
        Result result = new Result();
        result.setCode(com.model.adminmodel.enums.Result.RESULT_SUCCESS.getCode());
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /**
     * 错误信息返回
     * @param msg
     * @return
     */
    public static Result error(String msg){
        Result result = new Result();
        result.setCode(com.model.adminmodel.enums.Result.RESULT_ERROR.getCode());
        result.setMsg(msg);
        return result;
    }
}
