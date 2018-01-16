package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author boge
 * @date 18/1/15
 * @description 通用控制层
 */
@RestController
@RequestMapping("/common")
public class CommonController extends BaseController{

    //获取商品类型列表
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
     *                        value: "对应值"},
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
     *                        gtId: "对应商品类型主键"},
     *                     ...]
     *                     }
     */
    @GetMapping("/goods/class/{type}")
    public Result getCarClass(@PathVariable Byte type){
        return adminService.searchGoodsTypeItem(type);
    }
}
