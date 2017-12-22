package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.entity.User;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author boge
 * @date 17/12/19
 * @description: Main Page Controller
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    /**
     * @api {POST} /user 增加用户
     * @apiGroup User
     * @apiVersion 0.0.1
     * @apiDescription 增加用户
     * @apiParam {User} user 用户对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      username:"姓名",
     *                      mobile:"18710889234",
     *                      avatarId:"dasjhu2423523234"
     *                   }
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {GET} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("")
    public Result addUserInfo(User user){
        return userService.addUser(user);
    }

    @GetMapping("/{userId}")
    public Result getUserInfo(@PathVariable Integer userId){
        return null;
    }
}
