package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.constant.OrderConst;
import com.tangmo.shengmei.dao.GoodsOrderDao;
import com.tangmo.shengmei.entity.GoodsOrderSimple;
import com.tangmo.shengmei.service.GoodsOrderService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import com.tangmo.shengmei.utility.string.OrderRelated;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author boge
 * @date 18/3/8
 * @description
 */
@Service("orderService")
public class GoodsOrderServiceImpl implements GoodsOrderService {
    @Resource
    private GoodsOrderDao goodsOrderDao;
    @Override
    public Result addOrder(GoodsOrderSimple goodsOrderSimple) {
        if(goodsOrderSimple.getCdId() == null || goodsOrderSimple.getUserId()==null || goodsOrderSimple.getUaId() == null){
            return ResultUtil.fail();
        }
        String orderNo = OrderRelated.getOrderNo(goodsOrderSimple.getUserId());
        goodsOrderSimple.setOrderNumber(orderNo);
        goodsOrderSimple.setOrderState(OrderConst.NEW_ORDER);
        return ResultUtil.success(goodsOrderDao.insertGo(goodsOrderSimple));
    }

    @Override
    public Result searchOrderByState(Byte state,Integer userId,Integer start,Integer end) {
        return ResultUtil.success(goodsOrderDao.selectOrderByState(state,userId,start,end));
    }

    @Override
    public Result searchAllOrder(Integer userId,Integer start,Integer end) {
        return ResultUtil.success(goodsOrderDao.selectAllOrder(userId,start,end));
    }

    @Override
    public Result searchOrderDetail(Integer goId) {
        return ResultUtil.success(goodsOrderDao.selectById(goId));
    }

    @Override
    public Result payOrder(Integer goId) {
        return null;
    }
}
