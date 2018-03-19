package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.constant.GoodsBelongConst;
import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.entity.Commodity;
import com.tangmo.shengmei.entity.GoodsComment;
import com.tangmo.shengmei.entity.ShopGoods;
import com.tangmo.shengmei.entity.ShopServiceDto;
import com.tangmo.shengmei.utility.code.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author boge
 * @date 18/1/2
 * @description 店铺商品信息控制层
 */
@RestController
@RequestMapping("/shop")
public class ShopGoodsController extends BaseController{

    /**
     * @api {POST} /shop/service 增加商家服务
     * @apiGroup ShopGoods
     * @apiVersion 0.0.1
     * @apiDescription 增加商家服务
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
     *                      mobile:手机号,
     *                      city:"城市",
     *                      district:"区域"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/service")
    public Result addShopService(@RequestBody ShopGoods shopGoods){
        return shopGoodsService.addShopService(shopGoods);
    }

    /**
     * @api {PUT} /shop/service 修改商家服务
     * @apiGroup ShopGoods
     * @apiVersion 0.0.1
     * @apiDescription 修改商家服务
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
    @PutMapping("/service")
    public Result changeShopService(@RequestBody ShopGoods shopGoods){
        return shopGoodsService.changeShopService(shopGoods);
    }

    /**
     * @api {GET} /shop/service/list/{type}/{start}/{end} 获取指定类型服务列表
     * @apiGroup ShopGoods
     * @apiVersion 0.0.1
     * @apiParam {byte} type 服务类型
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiDescription 获取指定类型服务列表 汽车美容,改装...
     * @apiParamExample {json} 请求样例：
     *  /shop/service/list/1/0/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        sgId: 1,
     *                        shopName "店铺名",
     *                        imgId:"商品图片",
     *                        shopContent: "店铺介绍",
     *                        price:"价格",
     *                        city:"城市",
     *                        district:"区域"
     *                      }
     *                     {
     *                        sgId: 2,
     *                        shopName: "店铺名",
     *                        imgId:"商品图片",
     *                        shopContent: "店铺介绍",
     *                        price:"价格",
     *                        city:"城市",
     *                        district:"区域"
     *                     }]
     *                     }
     */
    @GetMapping("/service/list/{type}/{start}/{end}")
    public Result searchShopService(@PathVariable Byte type,@PathVariable Integer start,@PathVariable Integer end){
        return shopGoodsService.searchServiceByType(type, start, end);
    }

    /**
     * @api {GET} /shop/service/detail/{sgId} 获取服务详情
     * @apiGroup ShopGoods
     * @apiVersion 0.0.1
     * @apiDescription 获取服务详情
     * @apiParamExample {json} 请求样例：
     *  /shop/service/detail/1
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                      username:"发布人",
     *                      shopName:"标题是什么",
     *                      shopContent:"内容是什么",
     *                      imgId:"图片base64编码",
     *                      imgList:"图片列表",
     *                      city:"市",
     *                      price:"商品价格",
     *                      address:"地址",
     *                      mobile:"手机",
     *                      discountNote:"打折活动"
     *                   }
     *                   }
     */
    @GetMapping("/service/detail/{sgId}")
    public Result searchSgDetail(@PathVariable Integer sgId){
        return shopGoodsService.searchServiceDetail(sgId);
    }

    /**
     * @api {GET} /shop/service/select 筛选服务列表
     * @apiGroup ShopGoods
     * @apiVersion 0.0.1
     * @apiDescription 筛选服务列表
     * @apiParamExample {json} 请求样例：
     *                  {
     *                      type:服务类型,
     *                      city:"城市",
     *                      price:"价格排序 0,正序,1倒序"
     *                      priceStart:"价格开始区间",
     *                      priceEnd:"价格结束区间",
     *                      start:"分页开始索引,必填",
     *                      end:"分页查询长度,必填",
     *                   }
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        sgId: 1,
     *                        shopName "店铺名",
     *                        imgId:"商品图片",
     *                        shopContent: "店铺介绍",
     *                        price:"价格",
     *                        city:"城市",
     *                        district:"区域"
     *                      }
     *                     {
     *                        sgId: 2,
     *                        shopName: "店铺名",
     *                        imgId:"商品图片",
     *                        shopContent: "店铺介绍",
     *                        price:"价格",
     *                        city:"城市",
     *                        district:"区域"
     *                     }]
     *                     }
     */
    @GetMapping("/service/select")
    public Result searchByCondition(ShopServiceDto shopServiceDto){
        return shopGoodsService.searchByCondition(shopServiceDto);
    }

    /**
     * @api {POST} /shop/goods 增加商家商品
     * @apiGroup ShopGoods
     * @apiVersion 0.0.1
     * @apiDescription 增加商家商品
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      userId:"1",
     *                      title:"标题是",
     *                      content:"商品介绍",
     *                      province:"省",
     *                      city:"市",
     *                      district:"区",
     *                      priceNow:"价格",
     *                      cdType:"商品类型,0,1,2",
     *                      condition:"新旧程度",
     *                      cdCount:"商品数量",
     *                      cdColor:"商品颜色,多种颜色以逗号分隔,
     *                      cdSize:"商品规格,多种规格以逗号分隔",
     *                      imgId:商品图片Id,
     *                      discountFee:打折费用,
     *                      expressFee:物流费用
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/goods")
    public Result addShopGoods(@RequestBody Commodity commodity){
        return commodityService.addCommodity(commodity);
    }

    /**
     * @api {PUT} /shop/goods 修改商家商品
     * @apiGroup ShopGoods
     * @apiVersion 0.0.1
     * @apiDescription 修改商家商品
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      cdId:"商品信息主键",
     *                      title:"标题",
     *                      content:"商品介绍",
     *                      priceNow:"价格",
     *                      cdType:"商品类型",
     *                      cdCount:"商品数量",
     *                      imgId:商品图片,
     *                      discountFee:"打折费用",
     *                      expressFee:"物流费用",
     *                      cdCount:"商品数量",
     *                      cdColor:"商品颜色,多种颜色以逗号分隔,
     *                      cdSize:"商品规格,多种规格以逗号分隔"
     *                   }
     * @apiSuccess (success) {PUT} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {PUT} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PutMapping("/goods")
    public Result changeCommodity(@RequestBody Commodity commodity){
        return commodityService.changeCommodity(commodity,null);
    }

}
