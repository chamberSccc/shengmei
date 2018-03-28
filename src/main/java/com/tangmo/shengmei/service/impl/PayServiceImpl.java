package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.PayDao;
import com.tangmo.shengmei.entity.Pay;
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
        payDao.insertPay(pay);
        return ResultUtil.success();
    }

    @Override
    public Result addPayInfo(Map<String, String> map) {
        Pay pay = new Pay();
        pay.setOut_trade_no(map.get("out_trade_no"));
        pay.setTotal_fee(Integer.parseInt(map.get("total_fee")));
        pay.setTrade_type(map.get("trade_type"));
        pay.setReturn_msg(map.get("return_msg"));
        pay.setResult_code(map.get("result_code"));
        return addPayInfo(pay);
    }

    @Override
    public Result selectByTradeNo(String tradeNo) {
        Pay pay = payDao.selectByTradeNo(tradeNo);
        if(pay == null){
            return ResultUtil.pending();
        }else{
            if (pay.getReturn_msg()!= null){
                return ResultUtil.error(pay.getReturn_msg());
            }else{
                return ResultUtil.success();
            }
        }
    }
}
