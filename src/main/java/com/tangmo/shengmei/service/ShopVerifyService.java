package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.ShopVerify;
import com.tangmo.shengmei.utility.code.Page;
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
     * @return
     */
    Result addShopVerify(ShopVerify shopVerify);

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

    /**
     * 后台商家审核信息分页
     *
     * @param state
     * @param page
     * @return
     */
    Result searchSvInfo(Byte state, Page page);

    /**
     * 修改商家信息
     *
     * @param shopVerify
     * @return
     */
    Result changeSvInfo(ShopVerify shopVerify);

    /**
     * 修改商家审核信息
     *
     * @param svId
     * @param state
     * @return
     */
    Result updateSvState(Integer svId, Byte state);
}
