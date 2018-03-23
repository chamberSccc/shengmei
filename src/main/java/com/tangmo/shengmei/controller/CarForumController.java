package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.constant.CarForumTypeConst;
import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.entity.CarForum;
import com.tangmo.shengmei.entity.ForumComment;
import com.tangmo.shengmei.entity.ForumStar;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author boge
 * @date 18/3/21
 * @description
 */
@RestController
@RequestMapping("/moments")
public class CarForumController extends BaseController{

    /**
     * @api {POST} /moments/forum 增加车友圈
     * @apiGroup Forum
     * @apiVersion 0.0.1
     * @apiDescription 增加车友圈
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      userId:"用户Id",
     *                      content:"贴子内容",
     *                      mediaId:"图片id,多个图片用逗号分隔"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/forum")
    public Result addCarForum(@RequestBody CarForum carForum){
        carForum.setCfType(CarForumTypeConst.CAR_FORUM);
        return carForumService.addCarForum(carForum);
    }

    /**
     * @api {POST} /moments/video 增加车友圈视频
     * @apiGroup Forum
     * @apiVersion 0.0.1
     * @apiDescription 增加车友圈视频
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      userId:"用户Id",
     *                      content:"贴子内容",
     *                      mediaId:"视频Id"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/video")
    public Result addCarVideo(@RequestBody CarForum carForum){
        carForum.setCfType(CarForumTypeConst.CAR_VIDEO);
        return carForumService.addCarForum(carForum);
    }

    /**
     * @api {POST} /moments/comment 增加车友圈评论
     * @apiGroup Forum
     * @apiVersion 0.0.1
     * @apiDescription 增加车友圈视频
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      cfId:"车友圈Id"
     *                      userId:"用户Id",
     *                      content:"评论内容",
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/comment")
    public Result addForumComment(@RequestBody ForumComment forumComment){
        return carForumService.addForumComment(forumComment);
    }

    /**
     * @api {POST} /moments/star 增加车友圈好评
     * @apiGroup Forum
     * @apiVersion 0.0.1
     * @apiDescription 增加车友圈好评
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      cfId:"车友圈Id"
     *                      userId:"用户Id",
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/star")
    public Result addForumStar(@RequestBody ForumStar forumStar){
        return carForumService.addForumStar(forumStar);
    }

    /**
     * @api {GET} /moments/list/forum/{start}/{end} 车友圈列表
     * @apiGroup Forum
     * @apiVersion 0.0.1
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiDescription 车友圈列表
     * @apiParamExample {json} 请求样例：
     *  /moments/list/forum/1/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        cfId: 主键,
     *                        content: "车友圈内容",
     *                        userId:"用户id",
     *                        userName:"用户姓名",
     *                        viewCount:"浏览数",
     *                        commentCount:"评论数",
     *                        starCount:"好评数",
     *                        imgList:"图片数组",
     *                        },{...}
     *                     ]
     *                     }
     */
    @GetMapping("/list/forum/{start}/{end}")
    public Result getCarForumList(@PathVariable Integer start,@PathVariable Integer end){
        return carForumService.searchForumList(CarForumTypeConst.CAR_FORUM,start,end);
    }

    /**
     * @api {GET} /moments/list/video/{start}/{end} 车友圈视频列表
     * @apiGroup Forum
     * @apiVersion 0.0.1
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiDescription 车友圈视频列表
     * @apiParamExample {json} 请求样例：
     *  /moments/list/video/1/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        cfId: 主键,
     *                        content: "车友圈内容",
     *                        userId:"用户id",
     *                        userName:"用户姓名",
     *                        viewCount:"浏览数",
     *                        commentCount:"评论数",
     *                        starCount:"好评数",
     *                        mediaId:"视频文件Id",
     *                        },{...}
     *                     ]
     *                     }
     */
    @GetMapping("/list/video/{start}/{end}")
    public Result getForumVideoList(@PathVariable Integer start, @PathVariable Integer end){
        return carForumService.searchForumList(CarForumTypeConst.CAR_VIDEO,start,end);
    }

    /**
     * @api {GET} /moments/forum/user/{userId}/{start}/{end} 我的车友圈列表
     * @apiGroup Forum
     * @apiVersion 0.0.1
     * @apiParam {int} userId 用户Id
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiDescription 我的车友圈列表
     * @apiParamExample {json} 请求样例：
     *  /moments/forum/user/forum/1/1/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        cfId: 主键,
     *                        content: "车友圈内容",
     *                        viewCount:"浏览数",
     *                        commentCount:"评论数",
     *                        starCount:"好评数",
     *                        imgList:"图片数组",
     *                        mediaId:"视频文件",
     *                        cfType:0:车友圈,1:视频
     *                        },{...}
     *                     ]
     *                     }
     */
    @GetMapping("/forum/user/{userId}/{start}/{end}")
    public Result getUserCarForumList(@PathVariable Integer userId,@PathVariable Integer start,
                                      @PathVariable Integer end){
        return carForumService.searchForumList(userId,start,end);
    }


    /**
     * @api {GET} /moments/detail/{cfId} 车友圈详情
     * @apiGroup Forum
     * @apiVersion 0.0.1
     * @apiParam {int} cfId 车友圈Id
     * @apiDescription 车友圈详情
     * @apiParamExample {json} 请求样例：
     *  /moments/detail/1
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                        cfId: 主键,
     *                        content: "车友圈内容",
     *                        viewCount:"浏览数",
     *                        commentCount:"评论数",
     *                        starCount:"好评数",
     *                        imgList:"图片数组",
     *                        mediaId:"视频文件",
     *                        cfType:0:车友圈,1:视频
     *                     }
     */
    @GetMapping("/detail/{cfId}")
    public Result getForumDetail(@PathVariable Integer cfId){
        return carForumService.searchForumDetail(cfId);
    }

    /**
     * @api {GET} /moments/comment/{cfId}/{start}/{end} 车友圈评论
     * @apiGroup Forum
     * @apiVersion 0.0.1
     * @apiParam {int} cfId 车友圈主键
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiDescription 车友圈评论
     * @apiParamExample {json} 请求样例：
     *  /moments/comment/1/1/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        fsId: 主键,
     *                        content: "评论内容",
     *                        userId:"用户Id",
     *                        userName:"评论数",
     *                        avatarId:"头像",
     *                        createTime:"评论时间"
     *                        },{...}
     *                     ]
     *                     }
     */
    @GetMapping("/comment/{cfId}/{start}/{end}")
    public Result getForumComment(@PathVariable Integer cfId,@PathVariable Integer start,@PathVariable Integer end){
        return carForumService.selectForumComment(cfId,start,end);
    }
}
