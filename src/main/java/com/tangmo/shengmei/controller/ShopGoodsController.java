package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.entity.ShopGoods;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result test(ShopGoods shopGoods){
        return shopGoodsService.addShopGoods(shopGoods);
    }

}
