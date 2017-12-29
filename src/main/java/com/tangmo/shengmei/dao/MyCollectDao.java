package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.MyCollect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author boge
 * @date 17/12/29
 * @description 我的收藏Dao层
 */
@Mapper
public interface MyCollectDao {

    /**
     * 增加我的收藏信息
     *
     * @param myCollect
     * @return
     */
    int insertSelective(MyCollect myCollect);

    /**
     * 删除我的收藏信息
     *
     * @param mcId 我的收藏表主键
     * @return
     */
    int deleteById(Integer mcId);

    /**
     * 返回用户下的我的收藏信息信息
     *
     * @param userId 用户id
     * @paran start 开始索引
     * @paran end 结束索引
     * @return
     */
    List<MyCollect> selectListByUserId(@Param("userId") Integer userId, @Param("start") Integer start, @Param("end") Integer end);
}
