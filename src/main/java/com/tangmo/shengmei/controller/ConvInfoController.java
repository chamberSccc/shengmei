package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.entity.ConvComment;
import com.tangmo.shengmei.entity.ConvInfo;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author boge
 * @date 17/12/22
 * @description 便民信息控制器
 */
@RestController
@RequestMapping("/conv")
public class ConvInfoController extends BaseController {

    /**
     * @api {POST} /conv 增加便民信息
     * @apiGroup Convenient
     * @apiVersion 0.0.1
     * @apiDescription 增加便民信息
     * @apiParam {ConvInfo} convInfo 便民信息对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      userId:"用户Id",
     *                      title:"标题是什么",
     *                      content:"内容是什么"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("")
    public Result addConvInfo(@RequestBody ConvInfo convInfo){
        return convInfoService.addConvInfo(convInfo);
    }

    /**
     * @api {PUT} /conv 修改便民信息
     * @apiGroup Convenient
     * @apiVersion 0.0.1
     * @apiDescription 修改便民信息
     * @apiParam {ConvInfo} convInfo 便民信息对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      userId:"112312",
     *                      title:"标题是什么",
     *                      content:"内容是什么"
     *                   }
     * @apiSuccess (success) {PUT} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {PUT} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PutMapping("")
    public Result changeConvInfo(@RequestBody ConvInfo convInfo){
        return convInfoService.changeConvInfo(convInfo);
    }

    /**
     * @api {GET} /conv/list/{start}/{end} 获取便民信息列表
     * @apiGroup Convenient
     * @apiVersion 0.0.1
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiDescription 获取个人信息
     * @apiParamExample {json} 请求样例：
     *  /conv/list/1/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        ciId: 1,
     *                        title: "文章标题",
     *                        content: "文章内容",
     *                        userId:"用户id",
     *                        userName:"用户姓名",
     *                        viewCount:"浏览数",
     *                        commentCount:"评论数",
     *                        province:"省",
     *                        city:"市",
     *                        district:"区"},{...}
     *                     ]
     *                     }
     */
    @GetMapping("/list/{start}/{end}")
    public Result getConvInfo(@PathVariable Integer start,@PathVariable Integer end){
        return convInfoService.searchConvList(start,end);
    }

    /**
     * @api {DELETE} /conv/del/{ciId} 删除指定便民信息
     * @apiGroup Convenient
     * @apiVersion 0.0.1
     * @apiParam {int} ciId 便民信息表主键
     * @apiDescription 删除指定便民信息
     * @apiParamExample {json} 请求样例：
     *  /conv/del/12
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {DELETE} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @DeleteMapping("/del/{ciId}")
    public Result removeAddress(@PathVariable Integer ciId){
        return convInfoService.deleteConvInfo(ciId);
    }

    /**
     * @api {POST} /conv/comment 增加便民信息评论
     * @apiGroup Convenient
     * @apiVersion 0.0.1
     * @apiDescription 增加便民信息评论
     * @apiParam {ConvComment} convComment 评论对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      userId:"用户id",
     *                      ciId:"便民信息id",
     *                      comment:"评论内容"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/comment")
    public Result addComment(@RequestBody ConvComment convComment){
        return convInfoService.addComment(convComment);
    }

    /**
     * @api {GET} /conv/comment/list/{ciId}/{start}/{end} 获取便民信息评论
     * @apiGroup Convenient
     * @apiVersion 0.0.1
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiDescription 获取便民信息评论
     * @apiParamExample {json} 请求样例：
     *  /conv/comment/list/1/1/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        ccId: 评论Id,
     *                        userId: "用户Id",
     *                        userName:用户名字,
     *                        avatarId: "头像Id"},
     *                     {
     *                        ccId: 评论Id,
     *                        userId: "用户Id",
     *                        userName:用户名字,
     *                        avatarId: "头像Id"
     *                     }]
     *                     }
     */
    @GetMapping("/comment/list/{ciId}/{start}/{end}")
    public Result getCommentList(@PathVariable Integer ciId,@PathVariable Integer start,@PathVariable Integer end){
        return convInfoService.getCommentList(ciId,start,end);
    }

    /**
     * @api {GET} /conv/user/{userId}/{start}/{end} 获取用户便民信息
     * @apiGroup Convenient
     * @apiVersion 0.0.1
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiDescription 获取用户便民信息
     * @apiParamExample {json} 请求样例：
     *  /conv/user/1/1/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        ciId: 便民信息id,
     *                        userId:用户Id
     *                        viewCount:"浏览数",
     *                        commentCount:"评论数量",
     *                        isExpire:"是否失效",
     *                        title: "文章标题",
     *                        content: "文章内容"
     *                        },
     *                     {
     *                        ciId: 2,
     *                        userId:用户Id
     *                        viewCount:"浏览数",
     *                        commentCount:"评论数量",
     *                        isExpire:"是否失效",
     *                        title: "文章标题2",
     *                        content: "文章内容2"
     *                     }]
     *                     }
     */
    @GetMapping("/user/{userId}/{start}/{end}")
    public Result getUserConvInfo(@PathVariable Integer userId,@PathVariable Integer start,@PathVariable Integer end){
        return convInfoService.getUserConvInfo(userId, start, end);
    }

    /**
     * @api {GET} /conv/{ciId} 便民信息详情
     * @apiGroup Convenient
     * @apiVersion 0.0.1
     * @apiDescription 便民信息详情
     * @apiParamExample {json} 请求样例：
     *  /conv/1
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        ciId: 1,
     *                        title: "文章标题",
     *                        content: "文章内容",
     *                        userId:"用户id",
     *                        userName:"用户姓名",
     *                        viewCount:"浏览数",
     *                        commentCount:"评论数",
     *                        province:"省",
     *                        city:"市",
     *                        district:"区"},{...}
     *                     ]
     *                     }
     */
    @GetMapping("/{ciId}")
    public Result getConvDetail(@PathVariable Integer ciId){
        return convInfoService.searchConvDetail(ciId);
    }
}
