package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.PayDao;
import com.tangmo.shengmei.entity.Pay;
import com.tangmo.shengmei.entity.WeChatPayResultBean;
import com.tangmo.shengmei.service.PayService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author boge
 * @date 18/3/27
 * @description
 */
@Service("payService")
public class PayServiceImpl implements PayService{
    @Resource
    private PayDao payDao;
    @Override
    public Result addPayInfo(Pay pay) {
        payDao.addPrePay(pay);
        return ResultUtil.success();
    }

    @Override
    public int updatePayStatus(Integer prepayId) {
        return 0;
    }

    @Override
    public Result addPayInfo(Map<String, String> map) {
        Pay pay = new Pay();
        pay.setOut_trade_no(map.get("out_trade_no"));
        pay.setTotal_fee(Integer.parseInt(map.get("total_fee")));
        pay.setTrade_type(map.get("trade_type"));
        pay.setOpenid(map.get("open_id"));
        return addPayInfo(pay);
    }
}
