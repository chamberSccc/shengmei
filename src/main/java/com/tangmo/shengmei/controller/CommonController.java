package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.constant.ParamConst;
import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.entity.ParamValue;
import com.tangmo.shengmei.utility.code.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

/**
 * @author boge
 * @date 18/1/15
 * @description 通用控制层
 */
@RestController
@RequestMapping("/common")
public class CommonController extends BaseController{

    /**
     * @api {GET} /common/goods/type 获取商品类型列表
     * @apiGroup Common
     * @apiVersion 0.0.1
     * @apiDescription 获取商品类型列表
     * @apiParamExample {json} 请求样例：
     *  /common/goods/type
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        id: "类型主键",
     *                        name:名称,
     *                        value: "对应数字值"},
     *                     ...]
     *                     }
     */
    @GetMapping("/goods/type")
    public Result getGoodsType(){
        return adminService.searchGoodsType();
    }

    /**
     * @api {GET} /common/goods/class/{type} 获取商品分类列表
     * @apiGroup Common
     * @apiVersion 0.0.1
     * @apiDescription 获取商品分类列表
     * @apiParamExample {json} 请求样例：
     *  /common/goods/class/1
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        id: "分类主键",
     *                        name:"名称",
     *                        gtId: "对应商品类型主键",
     *                        value:"对应数字值"},
     *                     ...]
     *                     }
     */
    @GetMapping("/goods/class/{type}")
    public Result getCarClass(@PathVariable Integer type){
        return adminService.searchGoodsTypeItem(type);
    }


    /**
     * @api {POST} /common/goods/color 增加商品颜色
     * @apiGroup Common
     * @apiVersion 0.0.1
     * @apiDescription 增加商品颜色
     * @apiParam {ParamValue} paramValue 参数对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      paramValue:"参数值"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/goods/color")
    public Result addGoodsColor(@RequestBody ParamValue paramValue){
        paramValue.setParamType(ParamConst.GOODS_COLOR);
        return null;
    }

    /**
     * @api {POST} /common/goods/size 增加商品规格
     * @apiGroup Common
     * @apiVersion 0.0.1
     * @apiDescription 增加商品规格
     * @apiParam {ParamValue} paramValue 参数对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      paramValue:"参数值"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/goods/size")
    public Result addGoodSize(@RequestBody ParamValue paramValue){
        paramValue.setParamType(ParamConst.GOODS_SIZE);
        return commonService.addParamValue(paramValue);
    }

    /**
     * @api {POST} /common/goods/condition 增加商品新旧程度
     * @apiGroup Common
     * @apiVersion 0.0.1
     * @apiDescription 增加商品规格
     * @apiParam {ParamValue} paramValue 参数对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      paramValue:"参数值"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/goods/condition")
    public Result addGoodCondition(@RequestBody ParamValue paramValue){
        paramValue.setParamType(ParamConst.GOODS_CONDITION);
        return commonService.addParamValue(paramValue);
    }

    /**
     * @api {GET} /common/goods/color 获取商品颜色列表
     * @apiGroup Common
     * @apiVersion 0.0.1
     * @apiDescription 获取商品颜色列表
     * @apiParamExample {json} 请求样例：
     *  /common/goods/color
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        pvId: "主键",
     *                        paramType:"类型",
     *                        paramValue: "参数值"
     *                        },
     *                     ...]
     *                     }
     */
    @GetMapping("/goods/color")
    public Result getGoodsColor(){
        return commonService.searchParamByType(ParamConst.GOODS_COLOR);
    }

    /**
     * @api {GET} /common/goods/condition 获取商品新旧程度列表
     * @apiGroup Common
     * @apiVersion 0.0.1
     * @apiDescription 获取商品颜色列表
     * @apiParamExample {json} 请求样例：
     *  /common/goods/condition
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        pvId: "主键",
     *                        paramType:"类型",
     *                        paramValue: "参数值"
     *                        },
     *                     ...]
     *                     }
     */
    @GetMapping("/goods/condition")
    public Result getGoodsCondition(){
        return commonService.searchParamByType(ParamConst.GOODS_CONDITION);
    }

    /**
     * @api {GET} /common/goods/size 获取商品规格列表
     * @apiGroup Common
     * @apiVersion 0.0.1
     * @apiDescription 获取商品规格列表
     * @apiParamExample {json} 请求样例：
     *  /common/goods/size
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        pvId: "主键",
     *                        paramType:"类型",
     *                        paramValue: "参数值"
     *                        },
     *                     ...]
     *                     }
     */
    @GetMapping("/goods/size")
    public Result getGoodSize(){
        return commonService.searchParamByType(ParamConst.GOODS_SIZE);
    }

    /**
     * @api {PUT} /common/param 修改参数值
     * @apiGroup Common
     * @apiVersion 0.0.1
     * @apiDescription 修改参数值
     * @apiParam {ParamValue} paramValue 参数对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      pvId:"参数主键",
     *                      paramValue:"参数值",
     *                   }
     * @apiSuccess (success) {PUT} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {PUT} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PutMapping("/param")
    public Result changeParam(@RequestBody ParamValue paramValue){
        return commonService.changeParamById(paramValue);
    }

    /**
     * @api {DELETE} /common/param/{pvId} 删除参数值
     * @apiGroup Common
     * @apiVersion 0.0.1
     * @apiParam {int} pvId 参数主键
     * @apiDescription 删除参数值
     * @apiParamExample {json} 请求样例：
     *  /common/param/1
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {DELETE} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @DeleteMapping("/param/{pvId}")
    public Result delParam(@PathVariable Integer pvId){
        return commonService.delParamById(pvId);
    }

    /**
     * @api {GET} /common/district 获取行政区域
     * @apiGroup Common
     * @apiVersion 0.0.1
     * @apiDescription 获取行政区域
     * @apiParamExample {json} 请求样例：
     *          {
     *              city: 西安
     *          }
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        id: "主键",
     *                        district:"区",
     *                     ...]
     *                     }
     */
    @GetMapping("/district")
    public Result getDistrict(String city){
        return commonService.searchDistrict(city);
    }
}
