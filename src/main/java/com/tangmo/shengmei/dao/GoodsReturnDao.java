package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.GoodsReturn;

/**
 * @author boge
 * @date 18/3/10
 * @description 退货原因dao
 */

public interface GoodsReturnDao {

    /**
     * 增加退货原因
     *
     * @param goodsReturn
     * @return
     */
    int insertGoodsReturn(GoodsReturn goodsReturn);

}
