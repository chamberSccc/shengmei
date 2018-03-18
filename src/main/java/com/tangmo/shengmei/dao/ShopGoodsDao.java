package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.GoodsComment;
import com.tangmo.shengmei.entity.ShopGoods;
import com.tangmo.shengmei.entity.ShopServiceDto;
import com.tangmo.shengmei.entity.vo.ShopServiceVO;
import com.tangmo.shengmei.entity.vo.SimpleShopGoodsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author boge
 * @date 17/12/29
 * @description 店铺商品Dao接口
 */

public interface ShopGoodsDao {

    /**
     * 增加店铺商服务信息
     *
     * @param shopGoods
     * @return
     */
    int insertSelective(ShopGoods shopGoods);

    /**
     * 修改店铺服务信息
     *
     * @param shopGoods
     * @return
     */
    int updateById(ShopGoods shopGoods);

    /**
     * 删除店铺服务信息
     *
     * @param sgId
     * @return
     */
    int deleteById(Integer sgId);

    /**
     * 查询店铺下的所有商品信息
     *
     * @param usId
     * @return
     */
    List<ShopGoods> selectListByUsId(Integer usId);

    /**
     * 查询精品信息列表
     *
     * @param start 开始索引
     * @param end   结束索引
     * @return
     */
    List<ShopGoods> selectQlList(@Param("start") Integer start, @Param("end") Integer end);

    /**
     * 查询精品信息列表
     *
     * @param type
     * @param start
     * @param end
     * @return
     */
    List<SimpleShopGoodsVO> selectByType(@Param("type") Byte type, @Param("start") Integer start, @Param("end") Integer end);

    /**
     * 查询商品服务详情
     *
     * @param sgId
     * @return
     */
    ShopServiceVO selectById(Integer sgId);

    /**
     * 获取商品评论列表
     *
     * @param goodsId 商品id
     * @param start   开始索引
     * @param end     结束索引
     * @return
     */
    List<GoodsComment> selectCommentByGoodsId(@Param("goodsId") Integer goodsId, @Param("start") Integer start,
                                              @Param("end") Integer end);

    /**
     * 根据条件筛选商品服务
     *
     * @param shopServiceDto
     * @return
     */
    List<SimpleShopGoodsVO> selectByCondition(ShopServiceDto shopServiceDto);


}
