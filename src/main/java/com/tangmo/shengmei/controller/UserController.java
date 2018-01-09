package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.entity.User;
import com.tangmo.shengmei.entity.WithDrawInfo;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author boge
 * @date 17/12/19
 * @description: 用户控制层
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    /**
     * @api {POST}  增加用户
     * @apiGroup User
     * @apiVersion 0.0.1
     * @apiDescription 增加用户
     * @apiParam {User} user 用户对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      username:"姓名",
     *                      mobile:"18710889234",
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("")
    public Result addUserInfo(User user){
        return userService.addUser(user);
    }

    /**
     * @api {GET} /user/{userId} 获取用户信息
     * @apiGroup User
     * @apiVersion 0.0.1
     * @apiParam {int} userId 用户表ID
     * @apiDescription 获取个人信息
     * @apiParamExample {json} 请求样例：
     *  /user/1
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     userId: 1,
     *                     username: "姓名",
     *                     mobile: "312445345",
     *                     province:"省份",
     *                     city:"市",
     *                     gender:"性别 0女  1男",
     *                     avatarId: "fsd42sd656sdasdasd",
     *                     }
     */
    @GetMapping("/{userId}")
    public Result getUserInfo(@PathVariable Integer userId){
        return userService.getUser(userId);
    }

    /**
     * @api {PUT} /user/change 修改用户信息
     * @apiGroup User
     * @apiVersion 0.0.1
     * @apiDescription 修改用户信息
     * @apiParam {User} user 用户信息对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      username:"姓名",
     *                      mobile:"18710889234",
     *                      province:"省份",
     *                      city:"市",
     *                      gender:"性别 0女  1男"
     *                   }
     * @apiSuccess (success) {PUT} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {PUT} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PutMapping("")
    public Result changeUserInfo(User user){
        return userService.changeUser(user);
    }

    /**
     * @api {PUT} /user/avatar 上传头像
     * @apiGroup User
     * @apiVersion 0.0.1
     * @apiDescription 上传头像
     * @apiParam {String} code 图片base64编码
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      avatarId:"图像base64编码",
     *                      userId:"用户id"
     *                   }
     * @apiSuccess (success) {PUT} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {PUT} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PutMapping("/avatar")
    public Result loadAvatar(User user){
        return userService.uploadAvatar(user.getUserId(),user.getAvatarId());
    }


    /**
     * @api {PUT} /mobile 修改手机
     * @apiGroup User
     * @apiVersion 0.0.1
     * @apiDescription 修改手机
     * @apiParam {String} code 图片base64编码
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      userId:"用户Id"
     *                      mobile:"新的手机号"
     *                   }
     * @apiSuccess (success) {PUT} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {PUT} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PutMapping("/mobile")
    public Result changeMobile(User user){
        return userService.updateMobile(user.getUserId(),user.getMobile());
    }

    /**
     * @api {GET} /mobile/check/{userId}/{mobile} 验证手机信息
     * @apiGroup User
     * @apiVersion 0.0.1
     * @apiDescription 验证手机信息
     * @apiParamExample {json} 请求样例：
     *  /mobile/check/1/18710829356
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{}
     */
    @GetMapping("/mobile/{userId}")
    public Result checkMobile(@PathVariable String mobile,@PathVariable Integer userId){
        return userService.checkMobile(userId,mobile);
    }

    /**
     * @api {PUT} /user/pwd 修改密码
     * @apiGroup User
     * @apiVersion 0.0.1
     * @apiDescription 修改密码
     * @apiParam {User} user user对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      userId:"用户Id",
     *                      password:"旧密码",
     *                      newPwd:"新密码"
     *                   }
     * @apiSuccess (success) {PUT} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {PUT} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PutMapping("/pwd")
    public Result changePwd(User user){
        return userService.changePwd(user);
    }

    /**
     * @api {POST} /user/withdraw 增加提现记录
     * @apiGroup User
     * @apiVersion 0.0.1
     * @apiDescription 增加提现记录
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      amount:"提现金额",
     *                      userId:"用户id",
     *                      wiWay:"提现方式",
     *                      orderNum:"订单号"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/withdraw")
    public Result addWithDraw(WithDrawInfo withDrawInfo){
        return userService.addWithDraw(withDrawInfo);
    }

    /**
     * @api {GET} /user/withdraw/{userId} 获取提现记录列表
     * @apiGroup User
     * @apiVersion 0.0.1
     * @apiDescription 获取提现记录列表
     * @apiParamExample {json} 请求样例：
     *  /user/withdraw/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        wiId: 1,
     *                        amount: "提现金额",
     *                        orderNum: "订单号",
     *                        wiWay:"提现方式"},
     *                     {
     *                        wiId: 1,
     *                        amount: "提现金额",
     *                        orderNum: "订单号",
     *                        wiWay:"提现方式"},
     *                     }]
     *                     }
     */
    @GetMapping("/withdraw/{userId}")
    public Result getWithDrawInfo(@PathVariable Integer userId){
        return userService.searchWithDrawInfo(userId);
    }

}
