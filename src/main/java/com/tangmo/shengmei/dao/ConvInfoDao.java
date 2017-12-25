package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.ConvInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author boge
 * @date 17/12/22
 * @description 便民信息Dao接口
 */
@Mapper
public interface ConvInfoDao {

    /**
     * 新增便民信息Selective
     *
     * @param convInfo
     * @return
     */
    int insertSelective(ConvInfo convInfo);

    /**
     * 通过主键修改便民信息
     *
     * @param convInfo
     * @return
     */
    int updateById(ConvInfo convInfo);

    /**
     * 获取便民信息列表
     *
     * @param start
     * @param end
     * @return
     */
    List<ConvInfo> selectConvList(@Param("start") Integer start, @Param("end") Integer end);
}
