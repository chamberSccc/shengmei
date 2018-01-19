package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.entity.FeedBack;
import com.tangmo.shengmei.entity.User;
import com.tangmo.shengmei.entity.WithDrawInfo;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import com.tangmo.shengmei.utility.string.SendMsg;
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
     * @api {POST} /user/register 增加用户
     * @apiGroup User
     * @apiVersion 0.0.1
     * @apiDescription 增加用户
     * @apiParam {User} user 用户对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      username:"姓名",
     *                      mobile:"18710889234",
     *                      password:"MD5加密后的密码",
     *                      province:"省",
     *                      city:"市",
     *                      authCode:"验证码"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；code_error：验证码错误；registered：手机号已被注册;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/register")
    public Result addUserInfo(@RequestBody User user){
        String code = (String) getSession().getAttribute(user.getMobile());
        if(code == null){
            return ResultUtil.codeError();
        }
        if(!code.equals(user.getAuthCode())){
            return ResultUtil.codeError();
        }
        return userService.addUser(user);
    }

    /**
     * @api {POST} /user/login 用户登录
     * @apiGroup User
     * @apiVersion 0.0.1
     * @apiDescription 用户登录
     * @apiParam {User} user 用户对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      password:"MD5加密后的密码",
     *                      mobile:"18710889234",
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；pwd_error：密码错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/login")
    public Result userLogin(@RequestBody User user){
        return userService.login(user);
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
    public Result changeUserInfo(@RequestBody User user){
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
    public Result loadAvatar(@RequestBody User user){
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
     *                      authCode:"验证码"
     *                   }
     * @apiSuccess (success) {PUT} code success:请求成功； fail:请求失败；code_error：验证码错误；param_error：请求参数错误;
     * @apiSuccess (success) {PUT} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PutMapping("/mobile")
    public Result changeMobile(@RequestBody User user){
        //先从数据库查询旧数据
        Result result = userService.getUser(user.getUserId());
        User checkUser = (User) result.getData();
        if(checkUser.getMobile() == null){
            return ResultUtil.fail();
        }
        String code = (String) getSession().getAttribute(checkUser.getMobile());
        if(code == null){
            return ResultUtil.codeError();
        }
        if(!code.equals(user.getAuthCode())){
            return ResultUtil.codeError();
        }
        return userService.updateMobile(user.getUserId(),user.getMobile());
    }

    /**
     * @api {GET} /mobile/check/{userId}/{mobile}/{authCode}} 验证手机信息
     * @apiGroup User
     * @apiVersion 0.0.1
     * @apiDescription 验证手机信息
     * @apiParamExample {json} 请求样例：
     *  /mobile/check/1/18710829356/3267
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；code_error：验证码错误；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{}
     */
    @GetMapping("/mobile/check/{userId}/{mobile}/{authCode}")
    public Result checkMobile(@PathVariable String mobile,@PathVariable Integer userId,@PathVariable String authCode){
        String code = (String) getSession().getAttribute(mobile);
        if(code == null){
            return ResultUtil.codeError();
        }
        if(!code.equals(authCode)){
            return ResultUtil.codeError();
        }
        return userService.checkMobile(userId,mobile);
    }

    /**
     * @api {GET} /mobile/auth/{mobile} 获取手机验证码
     * @apiGroup User
     * @apiVersion 0.0.1
     * @apiDescription 获取手机验证码
     * @apiParamExample {json} 请求样例：
     *  /mobile/auth/18710829356
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{}
     */
    @GetMapping("/mobile/auth/{mobile}")
    public Result getAuthCode(@PathVariable String mobile){
        String code = SendMsg.getRandomCode();
        this.getSession().setAttribute(mobile,code);
        return ResultUtil.success(code);
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
     *                      authCode:"短信验证码",
     *                      password:"旧密码",
     *                      newPwd:"新密码"
     *                   }
     * @apiSuccess (success) {PUT} code success:请求成功； fail:请求失败；code_error：验证码错误；param_error：请求参数错误;
     * @apiSuccess (success) {PUT} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PutMapping("/pwd")
    public Result changePwd(@RequestBody User user){
        String code = (String) getSession().getAttribute(user.getMobile());
        if(code == null){
            return ResultUtil.codeError();
        }
        if(!code.equals(user.getAuthCode())){
            return ResultUtil.codeError();
        }
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
    public Result addWithDraw(@RequestBody WithDrawInfo withDrawInfo){
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

    /**
     * @api {POST} /user/feedback 提交反馈
     * @apiGroup User
     * @apiVersion 0.0.1
     * @apiDescription 提交反馈
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      userId:"用户id",
     *                      content:"建议内容",
     *                      imgId:"base64编码",
     *                      mobile:"电话"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/feedback")
    public Result addFeedBack(@RequestBody FeedBack feedBack){
        return userService.addFeedBack(feedBack);
    }

    /**
     * @api {GET} /user/buy/{userId}}/{start}/{end} 购买记录
     * @apiGroup User
     * @apiVersion 0.0.1
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiParam {int} userId 用户Id
     * @apiDescription 购买记录
     * @apiParamExample {json} 请求样例：
     *  /user/buy/1/1/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        brId: 1,
     *                        title: "商品信息标题1",
     *                        imgId:"商品图片",
     *                        content: "商品信息内容1",
     *                        amount:"价格",
     *                        brCount:"购买数量",
     *                        createTime:"购买时间"
     *                      },
     *                     {...}]
     *                     }
     */
    @GetMapping("/buy/{userId}/{start}/{end}")
    public Result getBuyRecord(@PathVariable Integer userId,@PathVariable Integer start,@PathVariable Integer end){
        return userService.searchBuyRecord(userId, start, end);
    }

    /**
     * @api {GET} /user/sell/{userId}}/{start}/{end} 卖出记录
     * @apiGroup User
     * @apiVersion 0.0.1
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiParam {int} userId 用户Id
     * @apiDescription 卖出记录
     * @apiParamExample {json} 请求样例：
     *  /user/sell/1/1/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        srId: 1,
     *                        title: "商品信息标题1",
     *                        imgId:"商品图片",
     *                        content: "商品信息内容1",
     *                        amount:"价格",
     *                        brCount:"购买数量",
     *                        createTime:"购买时间"
     *                      },
     *                     {...}]
     *                     }
     */
    @GetMapping("/sell/{userId}/{start}/{end}")
    public Result getSellRecord(@PathVariable Integer userId,@PathVariable Integer start,@PathVariable Integer end){
        return userService.searchSellRecord(userId, start, end);
    }

    /**
     * @api {DELETE} /user/buy/multi 删除多条购买记录
     * @apiGroup User
     * @apiVersion 0.0.1
     * @apiDescription 删除多条购买记录
     * @apiParam {int} brId 浏览记录主键
     * @apiParamExample {json} 请求样例:
     * /user/buy/multi?brId=1&brId=2
     * @apiSuccess (success) {DELETE} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {DELETE} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @DeleteMapping("/buy/multi")
    public Result delMultiBuyRecord(@RequestParam Integer[] brId){
        return userService.delMultiBuyRecord(brId);
    }

    /**
     * @api {DELETE} /user/sell/multi 删除多条卖出记录
     * @apiGroup User
     * @apiVersion 0.0.1
     * @apiDescription 删除多条购买记录
     * @apiParam {int} srId 浏览记录主键
     * @apiParamExample {json} 请求样例:
     * /user/sell/multi?srId=1&srId=2
     * @apiSuccess (success) {DELETE} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {DELETE} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @DeleteMapping("/sell/multi")
    public Result delMultiSellRecord(@RequestParam Integer[] srId){
        return userService.delMultiSellRecord(srId);
    }

    //购买
    @PostMapping("/buy")
    public Result addBuyRecord(){
        return null;
    }

}
