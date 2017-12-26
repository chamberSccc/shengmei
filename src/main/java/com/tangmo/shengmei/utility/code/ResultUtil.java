package com.tangmo.shengmei.utility.code;

/**
 * @author boge
 * @date 17/12/22
 * @description 返回Result工具类
 */

public class ResultUtil {

    /**
     * 创建Result对象
     *
     * @param code
     * @param data
     * @return
     */
    public static Result createResult(String code, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setData(data);
        return result;
    }

    public static Result createResult(String code) {
        return createResult(code, null);
    }

    public static Result success(Object data) {
        return createResult(Result.SUCCESS, data);
    }

    public static Result success() {
        return success(null);
    }

    public static Result fail() {
        return createResult(Result.FAIL);
    }
}