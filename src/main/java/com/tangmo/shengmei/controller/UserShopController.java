package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.entity.UserShop;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author boge
 * @date 17/12/29
 * @description 用户店铺信息控制层
 */
@RestController
@RequestMapping("/shop")
public class UserShopController extends BaseController {

    /**
     * @api {POST} /shop 增加店铺
     * @apiGroup UserShop
     * @apiVersion 0.0.1
     * @apiDescription 增加用户
     * @apiParam {UserShop} userShop 用户商品对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      mobile:"手机",
     *                      userId:"用户id",
     *                      usProvince:"省",
     *                      usCity:"市",
     *                      usDistrict:"区"
     *                      usName:"店铺名"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("")
    public Result addUserShop(UserShop userShop){
        return userShopService.addUserShop(userShop);
    }

    /**
     * @api {PUT} /shop 修改商铺
     * @apiGroup UserShop
     * @apiVersion 0.0.1
     * @apiDescription 增加用户
     * @apiParam {UserShop} userShop 用户商品对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      mobile:"手机",
     *                      userId:"用户id",
     *                      usProvince:"省",
     *                      usCity:"市",
     *                      usDistrict:"区"
     *                      usName:"店铺名"
     *                   }
     * @apiSuccess (success) {PUT} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {PUT} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PutMapping("")
    public Result changeUserShop(UserShop userShop){
        return userShopService.changeUserShop(userShop);
    }

    /**
     * @api {GET} /shop/{userId} 获取用户店铺信息
     * @apiGroup UserShop
     * @apiVersion 0.0.1
     * @apiParam {int} userId 用户表ID
     * @apiDescription 获取用户店铺信息
     * @apiParamExample {json} 请求样例：
     *  /shop/1
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     userId: 1,
     *                     username: "姓名",
     *                     mobile: "312445345",
     *                     avatarId: "fsd42sd656sdasdasd",
     *                     }
     */
    @GetMapping("/{userId}")
    public Result getUserShop(@PathVariable Integer userId){
        return userShopService.searchUserShop(userId);
    }

    /**
     * @api {PUT} /shop/logo 上传店铺LOGO
     * @apiGroup UserShop
     * @apiVersion 0.0.1
     * @apiDescription 上传店铺LOGO
     * @apiParam {String} code 图片base64编码
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      code:"sdfjsajfsa89878979hfhfakjdlkf",
     *                   }
     * @apiSuccess (success) {PUT} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {PUT} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PutMapping("/logo")
    public Result loadLogo(String code){
        return null;
    }


}
