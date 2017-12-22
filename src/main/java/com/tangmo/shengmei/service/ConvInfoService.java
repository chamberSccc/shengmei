package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.ConvInfo;
import com.tangmo.shengmei.utility.code.Result;

/**
 * @author boge
 * @date 17/12/22
 * @description 便民信息服务
 */

public interface ConvInfoService {

    /**
     * 增加便民信息
     *
     * @param convInfo
     * @return
     */
    Result addConvInfo(ConvInfo convInfo);

    /**
     * 修改便民信息
     *
     * @param convInfo
     * @return
     */
    Result changeConvInfo(ConvInfo convInfo);
}
