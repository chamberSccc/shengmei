package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.constant.OrderConst;
import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.entity.GoodsOrderSimple;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author boge
 * @date 18/3/8
 * @description
 */
@RestController
@RequestMapping("/order")
public class GoodsOrderController extends BaseController{

    /**
     * @api {POST} /order 增加订单
     * @apiGroup Order
     * @apiVersion 0.0.1
     * @apiDescription 增加订单
     * @apiParam {GoodsOrderSimple} goodsOrderSimple 订单对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      userId:"用户Id",
     *                      uaId:"用户地址Id",
     *                      cdId:"商品Id",
     *                      goCount:"商品数量",
     *                      expressFee:"物流费用",
     *                      discountFee:"优惠费用",
     *                      payFee:"实际支付费用",
     *                      cdSize:"商品规格",
     *                      cdColor:"商品颜色"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("")
    public Result addOrder(@RequestBody GoodsOrderSimple goodsOrderSimple){
        return goodsOrderService.addOrder(goodsOrderSimple);
    }

    /**
     * @api {GET} /order/all/{userId}/{start}/{end} 所有订单列表
     * @apiGroup Order
     * @apiVersion 0.0.1
     * @apiParam {int} userId 用户Id
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiDescription 所有订单列表
     * @apiParamExample {json} 请求样例：
     *  /order/all/1/1/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        goId: "订单Id",
     *                        cdId: "商品id",
     *                        orderState: "订单状态",
     *                        imgId:"商品图片",
     *                        title:"商品标题",
     *                        content:"商品内容",
     *                        payFee:"支付费用",
     *                     ]
     *                     }
     */
    @GetMapping("/all/{userId}/{start}/{end}")
    public Result searchAllOrder(@PathVariable Integer userId,@PathVariable Integer start,@PathVariable Integer end){
        return goodsOrderService.searchAllOrder(userId, start, end);
    }

    /**
     * @api {GET} /order/complete/{userId}/{start}/{end} 已完成订单列表
     * @apiGroup Order
     * @apiVersion 0.0.1
     * @apiParam {int} userId 用户Id
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiDescription 已完成订单列表
     * @apiParamExample {json} 请求样例：
     *  /order/complete/1/0/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        goId: "订单Id",
     *                        cdId: "商品id",
     *                        orderState: "订单状态",
     *                        imgId:"商品图片",
     *                        title:"商品标题",
     *                        content:"商品内容",
     *                        payFee:"支付费用",
     *                     ]
     *                     }
     */
    @GetMapping("/complete/{userId}/{start}/{end}")
    public Result searchCompleteOrder(@PathVariable Integer userId,@PathVariable Integer start,@PathVariable Integer end){
        return goodsOrderService.searchOrderByState(OrderConst.DEAL_DONE,userId,start,end);
    }

    /**
     * @api {GET} /order/incomplete/{userId}/{start}/{end} 未完成订单列表
     * @apiGroup Order
     * @apiVersion 0.0.1
     * @apiParam {int} userId 用户Id
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiDescription 未完成订单列表
     * @apiParamExample {json} 请求样例：
     *  /order/incomplete/1/0/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        goId: "订单Id",
     *                        cdId: "商品id",
     *                        orderState: "订单状态",
     *                        imgId:"商品图片",
     *                        title:"商品标题",
     *                        content:"商品内容",
     *                        payFee:"支付费用",
     *                     ]
     *                     }
     */
    @GetMapping("/incomplete/{userId}/{start}/{end}")
    public Result searchCommentOrder(@PathVariable Integer userId,@PathVariable Integer start,@PathVariable Integer end){
        return goodsOrderService.searchOrderByState(OrderConst.NEW_ORDER,userId,start,end);
    }

    /**
     * @api {GET} /order/detail/{goId}
     * @apiGroup Order
     * @apiVersion 0.0.1
     * @apiParam {int} cdId 商品主键
     * @apiParam {int} userId 商品类型
     * @apiDescription 获取商品详情
     * @apiParamExample {json} 请求样例：
     *  /commodity/detail/1
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                      goId:"订单Id",
     *                      cdId:"商品id",
     *                      userId:"用户id",
     *                      goCount:"商品数量",
     *                      orderState:"订单状态",
     *                      orderNumber:"订单号",
     *                      expressFee:"物流费用",
     *                      discountFee:"打折费用",
     *                      payFee:"实际支付费用",
     *                      createTime:"创建时间",
     *                      imgId:"商品图片",
     *                      cdColor:"商品颜色,
     *                      cdSize:"商品规格",
     *                      title:"商品标题",
     *                      content:"商品内容",
     *                      "address": {
     *                          "uaId": 1,
     *                          "city": "市",
     *                          "district": "区",
     *                          "address": "地址",
     *                          "recipient": "收件人",
     *                          "mobile": "手机号",
     *                          "userId": null,
     *                          "isDefault": 1,
     *                       }
     *                    }
     *                   }
     */
    @GetMapping("/detail/{goId}")
    public Result getDetail(@PathVariable Integer goId){
        return goodsOrderService.searchOrderDetail(goId);
    }

    @PutMapping("/pay/{goId}")
    public Result completeOrder(){
        return null;
    }
}
