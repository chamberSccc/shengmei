package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author boge
 * @date 17/12/25
 * @description 全新汽配控制层
 */

@RestController
@RequestMapping("/newKit")
public class CommodityController extends BaseController {
    /**
     * @api {POST} /newKit/add 增加全新汽配信息
     * @apiGroup Convenient
     * @apiVersion 0.0.1
     * @apiDescription 增加全新汽配信息
     * @apiParam {ConvInfo} convInfo 全新汽配对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      userId:"112312",
     *                      title:"标题是什么",
     *                      content:"内容是什么"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/add")
    public Result add(){
        return null;
    }
}
