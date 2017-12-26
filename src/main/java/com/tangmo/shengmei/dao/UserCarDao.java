package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.UserCar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author boge
 * @date 17/12/26
 * @description
 */
@Mapper
public interface UserCarDao {

    /**
     * 增加车辆信息Selective
     *
     * @param userCar 用户车俩信息实体
     * @return
     */
    int insertSelective(UserCar userCar);

    /**
     * 修改指定车辆信息
     *
     * @param userCar 用户车俩信息实体
     * @return
     */
    int updateById(UserCar userCar);

    /**
     * 根据用户id返回所有用户车辆信息
     *
     * @param userId 用户Id
     * @return
     */
    List<UserCar> selectListByUserId(Integer userId);

    /**
     * 根据主键删除指定车辆信息
     *
     * @param ucId 用户车辆表主键
     * @return
     */
    int deleteById(Integer ucId);
}
