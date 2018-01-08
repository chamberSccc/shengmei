package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.Commodity;
import com.tangmo.shengmei.entity.GoodsComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author boge
 * @date 17/12/27
 * @description 商品Dao接口
 */
@Mapper
public interface CommodityDao {

    /**
     * 增加商品信息
     *
     * @param commodity 商品实体类
     * @return
     */
    int insertSelective(Commodity commodity);

    /**
     * 通过主键更新商品信息
     *
     * @param commodity 商品实体类
     * @return
     */
    int updateById(Commodity commodity);

    /**
     * 通过主键删除商品信息
     *
     * @param cdId 主键id
     * @return
     */
    int deleteById(Integer cdId);

    /**
     * 返回某一类型商品信息
     *
     * @param cdType 商品类型
     * @param start  开始索引
     * @param end    结束索引
     * @return
     */
    List<Commodity> selectListByType(@Param("cdType") Byte cdType, @Param("start") Integer start, @Param("end") Integer end);

    /**
     * 根据用户id查询商品信息
     *
     * @param userId
     * @return
     */
    List<Commodity> selectListByUserId(Integer userId);

    /**
     * 获取商品评论列表
     * @param goodsId 商品id
     * @param start 开始索引
     * @param end 结束索引
     * @return
     */
    List<GoodsComment> selectCommentByGoodsId(@Param("goodsId") Integer goodsId,@Param("start") Integer start,
                                          @Param("end") Integer end);

    /**
     * 增加商品评论
     * @param goodsComment
     * @return
     */
    int insertComment(GoodsComment goodsComment);
}
