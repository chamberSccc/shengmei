package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.IllegalInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author boge
 * @date 18/1/16
 * @description 违章dao层
 */
@Mapper
public interface IllegalDao {

    /**
     * 增加违章信息
     *
     * @param illegalInfo
     * @return
     */
    int insertSelective(IllegalInfo illegalInfo);

    /**
     * 根据用户信息和车辆信息查询违章信息
     *
     * @param userId 用户Id
     * @param carId 车辆Id
     * @return
     */
    IllegalInfo selectByUserAndCar(Integer userId, Integer carId);

    /**
     * 更新违章信息
     *
     * @param illegalInfo
     * @return
     */
    int updateSelective(IllegalInfo illegalInfo);
}
