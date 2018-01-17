package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.IllegalInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
     * @param carId
     * @return
     */
    int selectByCarId(Integer carId);

    /**
     * 更新违章信息
     *
     * @param illegalInfo
     * @return
     */
    int updateSelective(IllegalInfo illegalInfo);

    /**
     * 查询违章列表
     *
     * @param start
     * @param end
     * @return
     */
    List<IllegalInfo> selectListInfo(@Param("start") Integer start, @Param("end") Integer end);
}
