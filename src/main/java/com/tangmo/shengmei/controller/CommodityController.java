package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.entity.Commodity;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author boge
 * @date 17/12/25
 * @description 全新汽配控制层
 */

@RestController
@RequestMapping("/commodity")
public class CommodityController extends BaseController {
    /**
     * @api {POST} /commodity/add 增加商品信息
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiDescription 增加商品信息
     * @apiParam {Commodity} commodity 商品信息对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      cdId:"商品信息主键",
     *                      title:"标题是什么",
     *                      content:"内容是什么",
     *                      imgId:"图片base64编码",
     *                      pricePre:"原价",
     *                      priceNow:"现价",
     *                      cdType:"商品类型",
     *                      cdCount:"商品数量",
     *                      cdColor:"商品颜色,多种颜色以逗号分隔,
     *                      cdSize:"商品规格,多种规格以逗号分隔"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/add")
    public Result addCommodity(Commodity commodity){
        return commodityService.addCommodity(commodity);
    }

    /**
     * @api {PUT} /commodity 修改商品信息
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiDescription 增加商品信息
     * @apiParam {Commodity} commodity 商品信息对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      cdId:"商品信息主键",
     *                      title:"标题是什么",
     *                      content:"内容是什么",
     *                      imgId:"图片base64编码",
     *                      pricePre:"原价",
     *                      priceNow:"现价",
     *                      cdType:"商品类型",
     *                      cdCount:"商品数量"
     *                   }
     * @apiSuccess (success) {PUT} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {PUT} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PutMapping("")
    public Result changeCommodity(Commodity commodity){
        return commodityService.changeCommodity(commodity);
    }

    /**
     * @api {GET} /commodity/list/{type}/{start}/{end} 获取指定类型商品
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiParam {byte} type 商品类型
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 分页结束索引
     * @apiDescription 获取指定类型商品
     * @apiParamExample {json} 请求样例：
     *  /commodity/list/1/1/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        cdId: 1,
     *                        title: "商品信息标题1",
     *                        content: "商品信息内容1",
     *                        pricePre:"商品原价1",
     *                        priceNow:"商品现价1",
     *                        cdType:"商品类型1",
     *                        cdCount:"商品数量1",
     *                        cdColor:"商品颜色,多种颜色以逗号分隔,
     *                        cdSize:"商品规格,多种规格以逗号分隔"},
     *                     {
     *                        cdId: 2,
     *                        title: "商品信息标题2",
     *                        content: "商品信息内容2",
     *                        pricePre:"商品原价2",
     *                        priceNow:"商品现价2",
     *                        cdType:"商品类型2",
     *                        cdCount:"商品数量2",
     *                        cdColor:"商品颜色,多种颜色以逗号分隔,
     *                        cdSize:"商品规格,多种规格以逗号分隔"},
     *                     }]
     *                     }
     */
    @GetMapping("/list/{type}/{start}/{end}")
    public Result getCommodityList(@PathVariable Integer start, @PathVariable Integer end,@PathVariable Byte type){
        return commodityService.searchCdList(type,start,end);
    }

    /**
     * @api {GET} /commodity/user/{userId} 获取指定用户的商品
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiParam {int} userId 商品类型
     * @apiDescription 获取指定用户的商品
     * @apiParamExample {json} 请求样例：
     *  /commodity/list/1/1/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        cdId: 1,
     *                        title: "商品信息标题1",
     *                        content: "商品信息内容1",
     *                        pricePre:"商品原价1",
     *                        priceNow:"商品现价1",
     *                        cdType:"商品类型1",
     *                        cdCount:"商品数量1",
     *                        cdColor:"商品颜色,多种颜色以逗号分隔,
     *                        cdSize:"商品规格,多种规格以逗号分隔"},
     *                     {
     *                        cdId: 2,
     *                        title: "商品信息标题2",
     *                        content: "商品信息内容2",
     *                        pricePre:"商品原价2",
     *                        priceNow:"商品现价2",
     *                        cdType:"商品类型2",
     *                        cdCount:"商品数量2",
     *                        cdColor:"商品颜色,多种颜色以逗号分隔,
     *                        cdSize:"商品规格,多种规格以逗号分隔"},
     *                     }]
     *                     }
     */
    @GetMapping("/user/{userId}")
    public Result getUserCdList(@PathVariable Integer userId){
        return commodityService.searchUserCdList(userId);
    }

    /**
     * @api {DELETE} /commodity/{cdId} 删除商品信息
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiParam {int} cdId 商品表主键
     * @apiDescription 删除用户地址信息
     * @apiParamExample {json} 请求样例：
     *  /commodity/12
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {DELETE} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @DeleteMapping("/{cdId}")
    public Result removeCommodity(@PathVariable Integer cdId){
        return commodityService.delCommodity(cdId);
    }
}
