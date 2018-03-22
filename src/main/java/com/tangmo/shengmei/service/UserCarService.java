package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.UserCar;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author boge
 * @date 17/12/26
 * @description
 */

public interface UserCarService {

    /**
     * 增加用户车辆信息
     *
     * @param userCar 用户车俩信息实体
     * @return
     */
    Result addUserCar(UserCar userCar);

    /**
     * 更改指定车辆信息
     *
     * @param userCar 用户车俩信息实体
     * @return
     */
    Result changeUserCar(UserCar userCar);

    /**
     * 查询用户所有车辆信息
     *
     * @param userId 用户表id
     * @return
     */
    Result searchCarList(Integer userId);

    /**
     * 删除指定用户车辆信息
     *
     * @param ucId 用户车辆表主键
     * @return
     */
    Result delUserCar(Integer ucId);


    /**
     * 违章信息补充
     *
     * @param carId
     * @param file
     * @return
     */
    Result uploadIllegalAttach(Integer carId, MultipartFile file);
}
