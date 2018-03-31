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

    /**
     * 获取区域
     *
     * @param city
     * @return
     */
    Result searchDistrict(String city);

    /**
     * 增加行政区域
     *
     * @param city
     * @param district
     * @return
     */
    Result addDistrict(String city, String district);

    /**
     * 参数格式删除区域
     *
     * @param district
     * @return
     */
    Result delDistrict(String district);

    /**
     * 删除商品规格
     *
     * @param pvId
     * @return
     */
    Result delCdSize(Integer pvId);
}
