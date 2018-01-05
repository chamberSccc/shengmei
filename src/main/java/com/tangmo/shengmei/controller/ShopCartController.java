package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.entity.ShopCart;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author boge
 * @date 17/12/27
 * @description 购物车控制层
 */
@RestController
@RequestMapping("/cart")
public class ShopCartController extends BaseController{
    /**
     * @api {POST} /cart/add 增加购物车信息
     * @apiGroup ShopCart
     * @apiVersion 0.0.1
     * @apiDescription 增加购物车信息
     * @apiParam {ShopCart} shopCart 购物车对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      userId:"用户id",
     *                      cdId:"商品id",
     *                      price:"商品jiage",
     *                      cdCount:"商品数量",
     *                      scColor:"商品颜色,
     *                      scSize:"商品规格
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/add")
    public Result addShopCart(ShopCart shopCart){
        return shopCartService.addShopCart(shopCart);
    }


    /**
     * @api {GET} /cart/list/{userId}/{start}/{end} 获取用户购物车信息
     * @apiGroup ShopCart
     * @apiVersion 0.0.1
     * @apiParam {int} userId 用户id
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 分页结束索引
     * @apiDescription 获取指定类型商品
     * @apiParamExample {json} 请求样例：
     *  /cart/list/1/1/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        scId: 1,
     *                        userId:"用户id",
     *                        cdId:"商品id",
     *                        price:"商品价格",
     *                        cdCount:"商品数量",
     *                        scColor:"商品颜色,
     *                        scSize:"商品规格",
     *                        createTime:"创建时间"},
     *                     {
     *                        scId: 1,
     *                        userId:"用户id",
     *                        cdId:"商品id",
     *                        price:"商品价格2",
     *                        cdCount:"商品数量2",
     *                        scColor:"商品颜色,
     *                        scSize:"商品规格",
     *                        createTime:"创建时间2"}
     *                     }]
     *                     }
     */
    @GetMapping("/list/{userId}/{start}/{end}")
    public Result getCommodityList(@PathVariable Integer start, @PathVariable Integer end, @PathVariable Integer userId){
        return shopCartService.searchUserCart(userId,start,end);
    }

    /**
     * @api {GET} /cart/{scId} 删除指定购物车信息
     * @apiGroup ShopCart
     * @apiVersion 0.0.1
     * @apiParam {int} scId 购物车表主键
     * @apiDescription 删除用户地址信息
     * @apiParamExample {json} 请求样例：
     *  /cart/12
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @DeleteMapping("/{scId}")
    public Result removeCart(@PathVariable Integer scId){
        return shopCartService.delCart(scId);
    }
}
