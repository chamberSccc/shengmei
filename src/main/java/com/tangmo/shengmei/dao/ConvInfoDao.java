package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.ConvInfo;

/**
 * @author boge
 * @date 17/12/22
 * @description 便民信息Dao接口
 */

public interface ConvInfoDao {

    /**
     * 新增便民对象Selective
     *
     * @param convInfo
     * @return
     */
    int insertSelective(ConvInfo convInfo);
}
