package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.DeliverRemind;

/**
 * @author boge
 * @date 18/3/10
 * @description
 */

public interface DeliverRemindDao {

    /**
     * 增加发货提醒
     * @param deliverRemind
     * @return
     */
    int insertDr(DeliverRemind deliverRemind);
}
