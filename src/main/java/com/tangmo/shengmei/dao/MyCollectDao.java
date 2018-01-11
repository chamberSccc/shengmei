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
     * @return
     * @paran start 开始索引
     * @paran end 结束索引
     */
    List<MyCollect> selectListByUserId(@Param("userId") Integer userId, @Param("start") Integer start, @Param("end") Integer end);

    /**
     * 删除多条我的收藏
     *
     * @param mcIds 我的收藏主键数组
     * @return
     */
    int deleteMultiMyCollect(Integer[] mcIds);
}
