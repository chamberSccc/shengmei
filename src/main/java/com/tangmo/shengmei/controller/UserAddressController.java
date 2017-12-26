package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.entity.UserAddress;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author boge
 * @date 17/12/25
 * @description
 */
@RestController
@RequestMapping("/address")
public class UserAddressController extends BaseController{

    /**
     * @api {POST} /address/add 增加地址信息
     * @apiGroup UserAddress
     * @apiVersion 0.0.1
     * @apiDescription 增加地址信息
     * @apiParam {UserAddress} UserAddress 用户地址对象
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
        return userAddressService.addUserAddress(userAddress);
    }

    /**
     * @api {POST} /address/change 修改地址信息
     * @apiGroup UserAddress
     * @apiVersion 0.0.1
     * @apiDescription 增加地址信息
     * @apiParam {UserAddress} UserAddress 用户地址对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      uaId: 本条记录id
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
    @PostMapping("/change")
    public Result changeAddress(UserAddress userAddress){
        return userAddressService.changeUserAddress(userAddress);
    }

    /**
     * @api {GET} /get/list/{userId} 获取用户地址信息
     * @apiGroup UserAddress
     * @apiVersion 0.0.1
     * @apiParam {int} userId 用户Id
     * @apiDescription 获取用户地址信息
     * @apiParamExample {json} 请求样例：
     *  /get/list/12
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        uaId: 1,
     *                        address: "地址信息1",
     *                        recipient: "收件人1",
     *                        mobile:"手机号1"},
     *                     {
     *                        uaId: 2,
     *                        address: "地址信息2",
     *                        recipient: "收件人2",
     *                        mobile:"手机号2"
     *                     }]
     *                     }
     */
    @GetMapping("/get/list/{userId}")
    public Result getAddressList(@PathVariable Integer userId){
        return userAddressService.searchAddressList(userId);
    }

    /**
     * @api {GET} /del/{uaId} 删除用户地址信息
     * @apiGroup UserAddress
     * @apiVersion 0.0.1
     * @apiParam {int} uaId 地址表主键
     * @apiDescription 删除用户地址信息
     * @apiParamExample {json} 请求样例：
     *  /del/12
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @GetMapping("/del/{uaId}")
    public Result removeAddress(@PathVariable Integer uaId){
        return userAddressService.delUserAddress(uaId);
    }
}
