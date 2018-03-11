package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.DeliverRemindDao;
import com.tangmo.shengmei.entity.DeliverRemind;
import com.tangmo.shengmei.service.DeliverRemindService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author boge
 * @date 18/3/10
 * @description 发货提醒服务层
 */
@Service("deliverRemindService")
public class DeliverRemindServiceImpl implements DeliverRemindService {
    @Resource
    private DeliverRemindDao deliverRemindDao;

    @Override
    public Result addRemind(DeliverRemind deliverRemind) {
        deliverRemindDao.insertDr(deliverRemind);
        return ResultUtil.success();
    }
}
