package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.entity.UserAddress;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author boge
 * @date 17/12/25
 * @description
 */
@RestController
@RequestMapping("/address")
public class UserAddressController {

    /**
     * @api {POST} /address/add 增加地址信息
     * @apiGroup UserAddress
     * @apiVersion 0.0.1
     * @apiDescription 增加地址信息
     * @apiParam {UserAddress} UserAddress 全新汽配对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      userId:"用户Id",
     *                      mobile:"手机号",
     *                      recipient:"收件人",
     *                      address:"地址信息"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/add")
    public Result addAddress(UserAddress userAddress){
        return null;
    }
}
