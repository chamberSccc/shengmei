package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.entity.MyCollect;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author boge
 * @date 17/12/29
 * @description 我的收藏控制层
 */
@RestController
@RequestMapping("/collect")
public class MyCollectController extends BaseController {

    /**
     * @api {GET} /collect/list/{userId}/{start}/{end} 查看我的收藏信息
     * @apiGroup MyCollect
     * @apiVersion 0.0.1
     * @apiParam {int} userId 用户id
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiDescription 查看我的收藏信息
     * @apiParamExample {json} 请求样例：
     *  /collect/list/1/1/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        mcId: "我的收藏主键",
     *                        userId:"用户id2",
     *                        cdId:"商品id2",
     *                        content:"商品描述"
     *                        title:"商品名",
     *                        imgId:"图像Id",
     *                        pricePre:"商品原价2",
     *                        pricePre:"商品现价2",
     *                        createTime:"创建时间2"},
     *                     {
     *                        mcId: "我的收藏主键",
     *                        userId:"用户id2",
     *                        cdId:"商品id2",
     *                        content:"商品描述"
     *                        title:"商品名",
     *                        imgId:"图像Id",
     *                        pricePre:"商品原价2",
     *                        pricePre:"商品现价2",
     *                        createTime:"创建时间2"}
     *                     }]
     *                     }
     */
    @GetMapping("/list/{userId}/{start}/{end}")
    public Result getCollectList(@PathVariable Integer start, @PathVariable Integer end, @PathVariable Integer userId){
        return myCollectService.searchMyCollect(userId,start,end);
    }
    /**
     * @api {POST} /collect 增加我的收藏
     * @apiGroup MyCollect
     * @apiVersion 0.0.1
     * @apiDescription 增加我的收藏
     * @apiParam {MyCollect} myCollect 我的收藏对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      userId:"用户id",
     *                      cdId:"商品id"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("")
    public Result addMyCollect(@RequestBody MyCollect myCollect){
        return myCollectService.addMyCollect(myCollect);
    }

    /**
     * @api {DELETE} /collect/{mcId} 删除我的收藏
     * @apiGroup MyCollect
     * @apiVersion 0.0.1
     * @apiParam {int} mcId 我的收藏主键
     * @apiDescription 删除我的收藏
     * @apiParamExample {json} 请求样例：
     *  /collect/12
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {DELETE} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @DeleteMapping("/{mcId}")
    public Result delMyCollect(@PathVariable  Integer mcId){
        return myCollectService.delMyCollect(mcId);
    }

    /**
     * @api {DELETE} /collect/multi 删除多条我的收藏
     * @apiGroup MyCollect
     * @apiVersion 0.0.1
     * @apiDescription 删除多条我的收藏
     * @apiParam {int} mcId 浏览记录主键
     * @apiParamExample {json} 请求样例:
     * /collect/multi?mcId=1&mcId=2
     * @apiSuccess (success) {DELETE} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {DELETE} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @DeleteMapping("/multi")
    public Result deleteMultiView(@RequestParam Integer[] mcId){
        return myCollectService.delMultiMyCollect(mcId);
    }
}
