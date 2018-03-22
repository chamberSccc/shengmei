package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.entity.CarForum;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author boge
 * @date 18/3/21
 * @description
 */
@RestController
@RequestMapping("/moments")
public class CarForumController {

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
        return null;
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
        return null;
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
    public Result addForumComment(){
        return null;
    }
}
