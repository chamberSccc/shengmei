package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.ShopVerify;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author boge
 * @date 18/3/9
 * @description
 */

public interface ShopVerifyService {

    /**
     * 增加商家审核信息
     *
     * @param shopVerify
     * @param idFront    身份证正面照片
     * @param idRear     身份证背面照片
     * @param logo       logo照片
     * @param license    营业执照照片
     * @return
     */
    Result addShopVerify(ShopVerify shopVerify, MultipartFile idFront, MultipartFile idRear,
                         MultipartFile logo, MultipartFile license);

    /**
     * 用户查找商家审核信息
     *
     * @param userId
     * @return
     */
    Result searchSvInfo(Integer userId);

    /**
     * 查找所有商家审核信息
     *
     * @param start
     * @param end
     * @return
     */
    Result searchAllSvInfo(Integer start, Integer end);

    /**
     * 根据商家审核状态查找商家审核信息
     *
     * @param state
     * @param start
     * @param end
     * @return
     */
    Result searchSvInfo(Byte state, Integer start, Integer end);
}
