package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.entity.ConvInfo;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     *                      userId:"112312",
     *                      title:"标题是什么",
     *                      content:"内容是什么"
     *                   }
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {GET} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("")
    public Result addConvInfo(ConvInfo convInfo){
        return convInfoService.addConvInfo(convInfo);
    }
}
