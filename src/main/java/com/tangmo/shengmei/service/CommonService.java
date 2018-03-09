package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.ParamValue;
import com.tangmo.shengmei.utility.code.Result;

/**
 * @author Chamber
 * @date 2018/3/9.
 */
public interface CommonService {

    /**
     * 增加参数值
     *
     * @param paramValue
     * @return
     */
    Result addParamValue(ParamValue paramValue);

    /**
     * 根据类型查询参数值
     *
     * @param type
     * @return
     */
    Result searchParamByType(Byte type);

    /**
     * 修改参数值
     *
     * @param paramValue
     * @return
     */
    Result changeParamById(ParamValue paramValue);

    /**
     * 删除参数值
     *
     * @param pvId
     * @return
     */
    Result delParamById(Integer pvId);
}
