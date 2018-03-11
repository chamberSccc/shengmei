package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.GoodsReturn;
import com.tangmo.shengmei.utility.code.Result;

/**
 * @author boge
 * @date 18/3/10
 * @description 退货原因服务层
 */

public interface GoodsReturnService {

    /**
     * 增加退货原因
     *
     * @param goodsReturn
     * @return
     */
    Result addGoodsReturn(GoodsReturn goodsReturn);
}
