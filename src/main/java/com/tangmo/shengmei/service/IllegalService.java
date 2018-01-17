package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.IllegalInfo;
import com.tangmo.shengmei.utility.code.Result;

/**
 * @author Chamber
 * @date 2018/1/17.
 */
public interface IllegalService {
    /**
     * 增加违章信息
     *
     * @param illegalInfo
     * @return
     */
    Result addIllegalInfo(IllegalInfo illegalInfo);

    /**
     * 修改违章信息
     *
     * @param illegalInfo
     * @return
     */
    Result changeIllegalInfo(IllegalInfo illegalInfo);

    /**
     * 获取违章信息列表
     * @param start
     * @param end
     * @return
     */
    Result getIllegalList(Integer start,Integer end);
}
