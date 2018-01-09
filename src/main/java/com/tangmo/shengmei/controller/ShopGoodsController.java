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
     * @api {POST} /shop/goods 增加店铺商品信息
     * @apiGroup ShopGoods
     * @apiVersion 0.0.1
     * @apiDescription 增加商品信息
     * @apiParam {ShopGoods} shopGoods 店铺商品信息
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      userId:"用户id",
     *                      goodsName:"商品名",
     *                      goodsContent:"内容是什么",
     *                      imgId:"图片base64编码",
     *                      goodsPrice:"商品价格",
     *                      goodsType:"商品类型",
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
     * @api {GET} /commodity/quality/list/{type}/{start}/{end} 获取精品信息列表
     * @apiGroup ShopGoods
     * @apiVersion 0.0.1
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 分页结束索引
     * @apiDescription 获取精品信息列表
     * @apiParamExample {json} 请求样例：
     *  /commodity/quality/list/1/1/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        sgId: 1,
     *                        goodsName: "商品名1",
     *                        goodsType: "商品类型1",
     *                        goodsContent:"商品描述",
     *                        imgId:"图片地址",
     *                        goodsPrice:"商品价格"},
     *                     {
     *                        sgId: 1,
     *                        goodsName: "商品名1",
     *                        goodsType: "商品类型1",
     *                        goodsContent:"商品描述",
     *                        imgId:"图片地址",
     *                        goodsPrice:"商品价格"},
     *                     }]
     *                     }
     */
    @GetMapping("/quality/list/{start}/{end}")
    public Result getQualityList(@PathVariable Integer start, @PathVariable Integer end){
        return shopGoodsService.searchQlList(start,end);
    }

    /**
     * @api {GET} /comment/list/{start}/{end} 获取商家商品评论
     * @apiGroup ShopGoods
     * @apiVersion 0.0.1
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 分页结束索引
     * @apiDescription 获取商家商品评论
     * @apiParamExample {json} 请求样例：
     *  /comment/list/1/1/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        ccId: 评论Id,
     *                        userId: "用户Id",
     *                        userName:用户名字
     *                        avatarId: "头像Id"},
     *                     {
     *                        ccId: 评论Id,
     *                        userId: "用户Id",
     *                        userName:用户名字
     *                        avatarId: "头像Id"
     *                     }]
     *                     }
     */
    @GetMapping("/comment/list/{goodsId}/{start}/{end}")
    public Result getCommentList(@PathVariable Integer goodsId,@PathVariable Integer start,@PathVariable Integer end){
        return commodityService.getComments(goodsId, GoodsBelongConst.SHOP_GOODS,start,end);
    }

    /**
     * @api {POST} /comment 增加商家商品评论
     * @apiGroup ShopGoods
     * @apiVersion 0.0.1
     * @apiDescription 增加商家商品评论
     * @apiParam {GoodsComment} goodsComment 商品评论对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      userId:"用户id",
     *                      ciId:"便民信息id",
     *                      content:"评论内容"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/comment")
    public Result addComment(@RequestBody GoodsComment goodsComment){
        goodsComment.setBelongType(GoodsBelongConst.SHOP_GOODS);
        return commodityService.addComment(goodsComment);
    }

}
