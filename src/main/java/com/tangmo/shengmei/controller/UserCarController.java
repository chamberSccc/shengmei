package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.entity.UserAddress;
import com.tangmo.shengmei.entity.UserCar;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author boge
 * @date 17/12/26
 * @description 用户车辆信息控制层
 */
@RestController
@RequestMapping("/car")
public class UserCarController extends BaseController {
    /**
     * @api {POST} /car/add 增加车辆信息
     * @apiGroup UserCar
     * @apiVersion 0.0.1
     * @apiDescription 增加车辆信息
     * @apiParam {UserCar} userCar 用户车辆对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      userId:"用户Id",
     *                      carNum:"车牌号: A13768",
     *                      carProvince:"车辆省份  陕,山...",
     *                      carType:"车类型 0:小车,1:大车",
     *                      engineNum:"发动机号",
     *                      frameNum:"车架号"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/add")
    public Result addCar(UserCar userCar){
        return userCarService.addUserCar(userCar);
    }

    /**
     * @api {POST} /address/change 修改车辆信息
     * @apiGroup UserCar
     * @apiVersion 0.0.1
     * @apiDescription 修改车辆信息
     * @apiParam {UserCar} userCar 用户车辆对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      ucId:"主键id",
     *                      userId:"用户Id",
     *                      carNum:"车牌号: A13768",
     *                      carProvince:"车辆省份  陕,山...",
     *                      carType:"车类型 0:小车,1:大车",
     *                      engineNum:"发动机号",
     *                      frameNum:"车架号"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/change")
    public Result changeCar(UserCar userCar){
        return userCarService.changeUserCar(userCar);
    }

    /**
     * @api {GET} /get/list/{userId} 获取用户车辆信息
     * @apiGroup UserCar
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
     *                        ucId: 1,
     *                        userId:"用户Id",
     *                        carNum:"车牌号: A13768",
     *                        carProvince:"车辆省份  陕,山...",
     *                        carType:"车类型 0:小车,1:大车",
     *                        engineNum:"发动机号",
     *                        frameNum:"车架号"
     *                      },
     *                     {
     *                        uaId: 2,
     *                        userId:"用户Id",
     *                        carNum:"车牌号: A13768",
     *                        carProvince:"车辆省份  陕,山...",
     *                        carType:"车类型 0:小车,1:大车",
     *                        engineNum:"发动机号",
     *                        frameNum:"车架号"
     *                     }]
     *                     }
     */
    @GetMapping("/get/list/{userId}")
    public Result getCarList(@PathVariable Integer userId){
        return userCarService.searchCarList(userId);
    }

    /**
     * @api {GET} /del/{ucId} 删除指定车辆信息
     * @apiGroup UserCar
     * @apiVersion 0.0.1
     * @apiParam {int} ucId 车辆表主键
     * @apiDescription 删除用户地址信息
     * @apiParamExample {json} 请求样例：
     *  /del/12
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @GetMapping("/del/{ucId}")
    public Result removeCar(@PathVariable Integer ucId){
        return userCarService.delUserCar(ucId);
    }
}
