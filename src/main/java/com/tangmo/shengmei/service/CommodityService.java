package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.Commodity;
import com.tangmo.shengmei.entity.CommodityDto;
import com.tangmo.shengmei.entity.GoodsComment;
import com.tangmo.shengmei.utility.code.Page;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.web.multipart.MultipartFile;

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
     * 上传商品图片
     *
     * @param userId
     * @param file
     * @return
     */
    Result addCdImg(Integer userId, MultipartFile file);

    /**
     * 修改商品信息
     *
     * @param commodity
     * @return
     */
    Result changeCommodity(Commodity commodity, MultipartFile file);

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
     * 获取分页商品列表
     *
     * @param cdType
     * @return
     */
    Result searchCdList(Byte cdType,Page page);

    /**
     * 查询指定用户的商品信息
     *
     * @param userId
     * @param start
     * @param end
     * @return
     */
    Result searchUserCdList(Integer userId, Integer start, Integer end);

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

    /**
     * 得到浏览记录
     *
     * @param userId
     * @param start
     * @param end
     * @return
     */
    Result getViewRecord(Integer userId, Integer start, Integer end);

    /**
     * 删除浏览记录
     *
     * @param vrId
     * @return
     */
    Result delViewRecord(Integer vrId);

    /**
     * 删除多条浏览记录
     *
     * @param vrIds 浏览记录主键数组
     * @return
     */
    Result delMultiViewRecord(Integer[] vrIds);

    /**
     * 根据条件筛选商品
     *
     * @param commodityDto
     * @return
     */
    Result selectByCondition(CommodityDto commodityDto);

    /**
     * 商品好评加1
     *
     * @param cdId   商品Id
     * @param userId 用户Id
     * @return
     */
    Result addCdStar(Integer cdId, Integer userId);

    /**
     * 获取指定类型的精品列表
     *
     * @param type
     * @param start
     * @param end
     * @return
     */
    Result searchTypeQualityList(Byte type, Integer start, Integer end);

    /**
     * 获取指定类型的热门排行榜
     *
     * @param type
     * @param start
     * @param end
     * @return
     */
    Result searchTypeStarList(Byte type, Integer start, Integer end);

    /**
     * 清空浏览记录
     *
     * @param userId
     * @return
     */
    Result emptyViewRecord(Integer userId);

    /**
     * 更改商品上下架状态
     *
     * @param cdId
     * @param state
     * @return
     */
    Result changeCdState(Integer cdId, Byte state);

    /**
     * 查询上架/下架商品销售记录
     *
     * @param userId
     * @param state
     * @param start
     * @param end
     * @return
     */
    Result searchSellRecord(Integer userId, Byte state, Integer start, Integer end);
}
