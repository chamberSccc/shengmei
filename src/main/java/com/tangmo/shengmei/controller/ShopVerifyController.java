package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.entity.ShopVerify;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author boge
 * @date 18/3/9
 * @description
 */
@RestController
@RequestMapping("/shop")
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
     *                      idFrontImg:"身份证正面照",
     *                      idRearImg:"身份证反面照",
     *                      logoImg:"logo图片",
     *                      licenseImg:"营业执照照片"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/verify")
    public Result addShopVerify(@RequestBody ShopVerify shopVerify){
        if(shopVerify == null){
            return ResultUtil.fail();
        }
        if(shopVerify.getLogoImg() == null || shopVerify.getIdRearImg() == null
                || shopVerify.getIdFrontImg() ==null || shopVerify.getLicenseImg() == null){
            return ResultUtil.error("确认图片信息是否上传完整");
        }
        return shopVerifyService.addShopVerify(shopVerify);
    }

    /**
     * @api {PUT} /shop/info 修改商家信息
     * @apiGroup ShopVerify
     * @apiVersion 0.0.1
     * @apiDescription 修改商家信息
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      svId: 信息主键,
     *                      userId:"用户Id",
     *                      shopName:"店铺名称",
     *                      shopIntro:"店铺描述",
     *                      shopAddress:"店铺地址",
     *                   }
     * @apiSuccess (success) {PUT} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {PUT} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PutMapping("/info")
    public Result changeShopVerify(@RequestBody ShopVerify shopVerify){
        return shopVerifyService.changeSvInfo(shopVerify);
    }

    /**
     * @api {GET} /shop/info/{userId} 查询商铺信息
     * @apiGroup ShopVerify
     * @apiVersion 0.0.1
     * @apiDescription 查询商铺信息
     * @apiParamExample {json} 请求样例：
     *  /shop/info/1
     * @apiParamExample {json} 返回样例:
     *                   {
     *                      userId:"用户Id",
     *                      userName:"代表人姓名",
     *                      idNumber:"身份证号",
     *                      mobile:"手机号",
     *                      shopName:"店铺名称",
     *                      shopIntro:"店铺描述",
     *                      shopAddress:"店铺地址",
     *                      idFrontImg:"身份证正面照",
     *                      idRearImg:"身份证反面照",
     *                      logoImg:"logo图片",
     *                      licenseImg:"营业执照照片"
     *                   }
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {GET} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @GetMapping("/info/{userId}")
    public Result searchShopInfo(@PathVariable Integer userId){
        return shopVerifyService.searchSvInfo(userId);
    }

    /**
     * @api {GET} /shop/unverify/{start}/{end} 查询未审核商铺信息
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 查询未审核商铺信息
     * @apiParamExample {json} 请求样例：
     *  /shop/unverify/0/10
     * @apiParamExample {json} 返回样例:
     *                   {
     *                      userId:"用户Id",
     *                      userName:"代表人姓名",
     *                      idNumber:"身份证号",
     *                      mobile:"手机号",
     *                      shopName:"店铺名称",
     *                      shopIntro:"店铺描述",
     *                      shopAddress:"店铺地址",
     *                      idFrontImg:"身份证正面照",
     *                      idRearImg:"身份证反面照",
     *                      logoImg:"logo图片",
     *                      licenseImg:"营业执照照片"
     *                   }
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {GET} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @GetMapping("/unverify/{start}/{end}")
    public Result searchUnverify(@PathVariable Integer start,@PathVariable Integer end){
        return shopVerifyService.searchSvInfo((byte) 0,start,end);
    }

    /**
     * @api {GET} /shop/verify/{start}/{end} 查询已审核商铺信息
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 查询已审核商铺信息
     * @apiParamExample {json} 请求样例：
     *  /shop/verify/0/10
     * @apiParamExample {json} 返回样例:
     *                   {
     *                      userId:"用户Id",
     *                      userName:"代表人姓名",
     *                      idNumber:"身份证号",
     *                      mobile:"手机号",
     *                      shopName:"店铺名称",
     *                      shopIntro:"店铺描述",
     *                      shopAddress:"店铺地址",
     *                      idFrontImg:"身份证正面照",
     *                      idRearImg:"身份证反面照",
     *                      logoImg:"logo图片",
     *                      licenseImg:"营业执照照片"
     *                   }
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {GET} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @GetMapping("/verify/{start}/{end}")
    public Result searchVerify(@PathVariable Integer start,@PathVariable Integer end){
        return shopVerifyService.searchSvInfo((byte) 1,start,end);
    }

    /**
     * @api {PUT} /shop/verify/{svId} 通过商家审核
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 通过商家审核
     * @apiParamExample {json} 请求样例:
     *              /shop/verify/1
     * @apiSuccess (success) {PUT} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {PUT} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PutMapping("/verify/{svId}")
    public Result verifyInfo(@PathVariable Integer svId){
        return shopVerifyService.updateSvState(svId, (byte) 1);
    }

}
