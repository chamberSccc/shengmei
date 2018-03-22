package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.IllegalInfo;
import com.tangmo.shengmei.entity.UserCar;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Chamber
 * @date 2018/1/17.
 */
public interface IllegalService {
    /**
     * 增加违章信息
     *
     * @param illegalInfo
     * @return
     */
    Result addIllegalInfo(IllegalInfo illegalInfo);

    /**
     * 修改违章信息
     *
     * @param illegalInfo
     * @return
     */
    Result changeIllegalInfo(IllegalInfo illegalInfo);

    /**
     * 获取违章信息列表
     *
     * @param start
     * @param end
     * @return
     */
    Result getIllegalList(Integer start, Integer end);

    /**
     * 获取实时违章信息
     *
     * @param userCar
     * @return
     */
    Result getCurrentIllegal(UserCar userCar);

    /**
     * 获取已存车辆违章信息
     *
     * @param carId
     * @return
     */
    Result getCurrentIllegal(Integer carId);

    /**
     * 驾照查分
     *
     * @param fileId
     * @param licenseId
     * @return
     */
    Result getCurrentLicenseScore(String fileId, String licenseId);

}
