package com.tangmo.shengmei.utility.code;

import lombok.Data;

/**
 * @author boge
 * @date 18/3/10
 * @description
 */
@Data
public class ErrorResult extends Result{
    public static final String FAIL = "fail";
    private String code;
    private String errorInfo;

    public ErrorResult() {
    }
}
