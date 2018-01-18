package com.tangmo.shengmei.utility.code;

import lombok.Data;

import java.io.Serializable;

/**
 * @author boge
 * @date 17/12/22
 * @description
 */

@Data
public class Result<T> implements Serializable {

    public static final String FAIL = "fail";
    public static final String SUCCESS = "success";
    public static final String PARAM_ERROR = "error";
    public static final String ERROR_MOBILE = "registered";
    public static final String PWD_ERROR="pwd_error";
    public static final String CODE_ERROR="code_error";

    private String code;
    private T data;

    public Result(){
        this.code = FAIL;
    }

    public Result(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public Result(String code) {
        this.code = code;
    }
}
