package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.entity.ShopVerify;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author boge
 * @date 18/3/9
 * @description
 */
@RestController
@RequestMapping("/shop/verify")
public class ShopVerifyController extends BaseController{

    /**
     * @api {POST} /shop/verify 增加商家审核信息
     * @apiGroup ShopVerify
     * @apiVersion 0.0.1
     * @apiDescription 增加商家审核信息
     * @apiParam {ShopVerify} shopVerify 商家审核对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      userId:"用户Id",
     *                      userName:"代表人姓名",
     *                      idNumber:"收件人",
     *                      mobile:"手机号",
     *                      shopName:"店铺名称",
     *                      shopIntro:"店铺描述",
     *                      shopAddress:"店铺地址",
     *                      idFront:"身份证正面照",
     *                      idRear:"身份证反面照",
     *                      logo:"logo图片",
     *                      license:"营业执照照片"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("")
    public Result addShopVerify(ShopVerify shopVerify, MultipartFile idFront,MultipartFile idRear,
                                MultipartFile logo, MultipartFile license){
        if(idFront == null || idRear == null || logo ==null || license == null){
            return ResultUtil.paramError();
        }
        if(shopVerify == null){
            return ResultUtil.paramError();
        }
        return shopVerifyService.addShopVerify(shopVerify, idFront, idRear, logo, license);
    }
}
