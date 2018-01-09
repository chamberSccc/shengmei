package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.Commodity;
import com.tangmo.shengmei.entity.GoodsComment;
import com.tangmo.shengmei.utility.code.Result;

/**
 * @author boge
 * @date 17/12/27
 * @description 商品信息服务
 */

public interface CommodityService {

    /**
     * 增加商品信息
     *
     * @param commodity 商品实体
     * @return
     */
    Result addCommodity(Commodity commodity);

    /**
     * 修改商品信息
     *
     * @param commodity
     * @return
     */
    Result changeCommodity(Commodity commodity);

    /**
     * 获取商品列表
     *
     * @param cdType 商品类型
     * @param start  开始索引
     * @param end    结束索引
     * @return
     */
    Result searchCdList(Byte cdType, Integer start, Integer end);

    /**
     * 查询指定用户的商品信息
     *
     * @param userId
     * @return
     */
    Result searchUserCdList(Integer userId);

    /**
     * 删除指定商品信息
     *
     * @param cdId
     * @return
     */
    Result delCommodity(Integer cdId);

    /**
     * 增加评论
     *
     * @param goodsComment
     * @return
     */
    Result addComment(GoodsComment goodsComment);

    /**
     * 获取商品评论列表
     *
     * @param goodsId    商品表主键
     * @param belongType 属于个人还是商家
     * @param start      开始索引
     * @param end        结束索引
     * @return
     */
    Result getComments(Integer goodsId, Byte belongType, Integer start, Integer end);

    /**
     * 得到商品详细信息
     *
     * @param userId
     * @param cdId
     * @return
     */
    Result getCommodityDetail(Integer userId, Integer cdId);

    /**
     * 得到精品商品信息
     *
     * @param start
     * @param end
     * @return
     */
    Result getQualityInfo(Integer start, Integer end);
}
