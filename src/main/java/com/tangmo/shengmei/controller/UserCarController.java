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
     * @api {POST} /car 增加车辆信息
     * @apiGroup UserCar
     * @apiVersion 0.0.1
     * @apiDescription 增加车辆信息
     * @apiParam {UserCar} userCar 用户车辆对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      userId:"用户Id",
     *                      carNum:"车牌号: 13768",
     *                      carProvince:"车辆省份  陕A,山A...",
     *                      carType:"车类型 0:小车,1:大车",
     *                      engineNum:"发动机号",
     *                      frameNum:"车架号"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("")
    public Result addCar(@RequestBody UserCar userCar){
        return userCarService.addUserCar(userCar);
    }

    /**
     * @api {PUT} /car 修改车辆信息
     * @apiGroup UserCar
     * @apiVersion 0.0.1
     * @apiDescription 修改车辆信息
     * @apiParam {UserCar} userCar 用户车辆对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      ucId:"主键id",
     *                      userId:"用户Id",
     *                      carNum:"车牌号: A13768",
     *                      carProvince:"车辆省份  陕A,山A...",
     *                      carType:"车类型 0:小车,1:大车",
     *                      engineNum:"发动机号",
     *                      frameNum:"车架号"
     *                   }
     * @apiSuccess (success) {PUT} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {PUT} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PutMapping("")
    public Result changeCar(@RequestBody UserCar userCar){
        return userCarService.changeUserCar(userCar);
    }

    /**
     * @api {GET} /car/list/{userId} 获取用户车辆信息
     * @apiGroup UserCar
     * @apiVersion 0.0.1
     * @apiParam {int} userId 用户Id
     * @apiDescription 获取用户地址信息
     * @apiParamExample {json} 请求样例：
     *  /car/list/12
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        ucId: 1,
     *                        userId:"用户Id",
     *                        carNum:"车牌号: 13768",
     *                        carProvince:"车辆省份  陕A,山A...",
     *                        carType:"车类型 0:小车,1:大车",
     *                        engineNum:"发动机号",
     *                        frameNum:"车架号"
     *                      },
     *                     {
     *                        uaId: 2,
     *                        userId:"用户Id",
     *                        carNum:"车牌号: 13768",
     *                        carProvince:"车辆省份  陕A,山A...",
     *                        carType:"车类型 0:小车,1:大车",
     *                        engineNum:"发动机号",
     *                        frameNum:"车架号"
     *                     }]
     *                     }
     */
    @GetMapping("/list/{userId}")
    public Result getCarList(@PathVariable Integer userId){
        return userCarService.searchCarList(userId);
    }

    /**
     * @api {DELETE} /car/{ucId} 删除指定车辆信息
     * @apiGroup UserCar
     * @apiVersion 0.0.1
     * @apiParam {int} ucId 车辆表主键
     * @apiDescription 删除用户地址信息
     * @apiParamExample {json} 请求样例：
     *  /car/12
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {DELETE} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @DeleteMapping("/{ucId}")
    public Result removeCar(@PathVariable Integer ucId){
        return userCarService.delUserCar(ucId);
    }


    /**
     * @api {GET} /illegal/info/{carId} 获取违章信息
     * @apiGroup UserCar
     * @apiVersion 0.0.1
     * @apiParam {int} carId 车辆Id
     * @apiDescription 获取违章信息
     * @apiParamExample {json} 请求样例：
     *  /illegal/info/12
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                        userId: 1,
     *                        carId:"车辆ID",
     *                        username:"姓名",
     *                        carProvince:"车辆省份  陕A,山A...",
     *                        carType:"车类型 0:小车,1:大车",
     *                        carNum:"12345"
     *                        [{
     *                            canHandle:"是否可以代缴",
     *                            address:"违章地址",
     *                            handleFee:"代缴费用",
     *                            content:"违章内容",
     *                            score:"扣分",
     *                            price:"金额",
     *                            time:"违章时间"
     *                        }
     *                        ]
     *                     }
     */
    @GetMapping("/illegal/info/{carId}")
    public Result searchIllegalInfo(@PathVariable Integer carId){
        return illegalService.getCurrentIllegal(carId);
    }

    /**
     * @api {GET} /license/score/{fileId}/{licenseId} 驾照查分
     * @apiGroup UserCar
     * @apiVersion 0.0.1
     * @apiParam {String} fileId 档案编号
     * @apiParam {String} licenseId 驾驶证号
     * @apiDescription 驾照查分
     * @apiParamExample {json} 请求样例：
     *  /license/score/12/12
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                        userId: 1,
     *                        carId:"车辆ID",
     *                        username:"姓名",
     *                        score:"扣分",
     *                        enddate:"有效时间"
     *                     }
     */
    @GetMapping("/license/score/{fileId}/{licenseId}")
    public Result searchLicenseScore(@PathVariable String fileId,@PathVariable String licenseId){
        return illegalService.getCurrentLicenseScore(fileId, licenseId);
    }
}
