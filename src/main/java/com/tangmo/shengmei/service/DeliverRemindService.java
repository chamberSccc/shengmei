package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.DeliverRemind;
import com.tangmo.shengmei.utility.code.Result;

/**
 * @author boge
 * @date 18/3/10
 * @description
 */

public interface DeliverRemindService {

    /**
     * 增加发货提醒
     *
     * @param deliverRemind
     * @return
     */
    Result addRemind(DeliverRemind deliverRemind);
}
