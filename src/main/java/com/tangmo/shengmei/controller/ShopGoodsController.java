package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.constant.GoodsBelongConst;
import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.entity.GoodsComment;
import com.tangmo.shengmei.entity.ShopGoods;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author boge
 * @date 18/1/2
 * @description 店铺商品信息控制层
 */
@RestController
@RequestMapping("/shop/goods")
public class ShopGoodsController extends BaseController{

    /**
     * @api {POST} /shop/goods 增加商家商品
     * @apiGroup ShopGoods
     * @apiVersion 0.0.1
     * @apiDescription 增加商家商品
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      userId:"1",
     *                      shopContent:"店铺介绍",
     *                      shopName:"店铺名"
     *                      price:"起步价",
     *                      serviceType:"3:汽车美容,5:故障快处,6:道路救援 8:需求通讯",
     *                      address:"店铺地址",
     *                      imgId:图片Id,
     *                      discountNote:打折活动,
     *                      mobile:手机号
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("")
    public Result addShopGoods(@RequestBody ShopGoods shopGoods){
        return shopGoodsService.addShopGoods(shopGoods);
    }

    /**
     * @api {PUT} /shop/goods 增加商家商品
     * @apiGroup ShopGoods
     * @apiVersion 0.0.1
     * @apiDescription 增加商家商品
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      sgId:"主键"
     *                      shopContent:"店铺介绍",
     *                      shopName:"店铺名"
     *                      price:"起步价",
     *                      serviceType:"3:汽车美容,5:故障快处,6:道路救援 8:需求通讯",
     *                      address:"店铺地址",
     *                      imgId:图片Id,
     *                      discountNote:打折活动,
     *                      mobile:手机号
     *                   }
     * @apiSuccess (success) {PUT} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {PUT} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PutMapping("")
    public Result changeShopGoods(@RequestBody ShopGoods shopGoods){
        return shopGoodsService.changeShopGoods(shopGoods);
    }


    @GetMapping("/quality/list/{start}/{end}")
    public Result getQualityList(@PathVariable Integer start, @PathVariable Integer end){
        return shopGoodsService.searchQlList(start,end);
    }


    @GetMapping("/comment/list/{goodsId}/{start}/{end}")
    public Result getCommentList(@PathVariable Integer goodsId,@PathVariable Integer start,@PathVariable Integer end){
        return commodityService.getComments(goodsId, GoodsBelongConst.SHOP_GOODS,start,end);
    }


    @PostMapping("/comment")
    public Result addComment(@RequestBody GoodsComment goodsComment){
        goodsComment.setBelongType(GoodsBelongConst.SHOP_GOODS);
        return commodityService.addComment(goodsComment);
    }

}
