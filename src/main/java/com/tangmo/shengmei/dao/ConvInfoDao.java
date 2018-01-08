package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.ConvComment;
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

    /**
     * 便民信息浏览量+1
     *
     * @param ciId 便民信息主键
     * @return
     */
    int updateViewCount(Integer ciId);

    /**
     * 便民信息评论+1
     *
     * @param ciId 便民信息主键
     * @return
     */
    int updateCommentCount(Integer ciId);

    /**
     * 增加便民信息评论
     *
     * @param convComment 便民信息对象
     * @return
     */
    int insertConvComment(ConvComment convComment);

    /**
     * 查询便民信息的评论
     *
     * @param ciId 便民信息主键
     * @param start 开始索引
     * @param end 结束索引
     * @return
     */
    List<ConvComment> selectCommentByCiId(@Param("ciId") Integer ciId,@Param("start") Integer start,
                                          @Param("end") Integer end);

    /**
     * 查询便民信息具体信息
     *
     * @param ciId 便民信息主键
     * @return
     */
    ConvInfo selectByCiId(Integer ciId);

    /**
     * 删除便民信息
     *
     * @param ciId
     * @return
     */
    int deleteById(Integer ciId);

    /**
     * 增加便民信息评论
     *
     * @param convComment 评论对象
     * @return
     */
    int addComment(ConvComment convComment);
}
