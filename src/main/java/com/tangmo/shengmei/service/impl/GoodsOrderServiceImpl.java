package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.constant.OrderConst;
import com.tangmo.shengmei.dao.CommodityDao;
import com.tangmo.shengmei.dao.GoodsOrderDao;
import com.tangmo.shengmei.entity.Commodity;
import com.tangmo.shengmei.entity.GoodsOrder;
import com.tangmo.shengmei.entity.GoodsOrderSimple;
import com.tangmo.shengmei.entity.vo.ExpressVO;
import com.tangmo.shengmei.service.GoodsOrderService;
import com.tangmo.shengmei.utility.JisuData.SearchExpress;
import com.tangmo.shengmei.utility.code.OrderCode;
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
    @Resource
    private CommodityDao commodityDao;
    @Override
    public Result addOrder(GoodsOrderSimple goodsOrderSimple) {
        if(goodsOrderSimple.getCdId() == null || goodsOrderSimple.getUserId()==null || goodsOrderSimple.getUaId() == null){
            return ResultUtil.error("请确认用户信息,商品信息,地址信息是否正确");
        }
        String orderNo = OrderRelated.getOrderNo(goodsOrderSimple.getUserId());
        goodsOrderSimple.setOrderNumber(orderNo);
        goodsOrderSimple.setOrderState(OrderConst.ORDER_NEW);
        Commodity commodity = commodityDao.selectCommodityDetail(goodsOrderSimple.getCdId());
        if(commodity == null){
            return ResultUtil.error("请确认商品信息是否正确");
        }
        if(commodity.getPriceNow() == null){
            return ResultUtil.error("该商品商家暂未标注价格");
        }
        goodsOrderSimple.setPayFee(goodsOrderSimple.getGoCount() * commodity.getPriceNow());
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

    @Override
    public Result delOrder(Integer goId) {
        goodsOrderDao.deleteById(goId);
        return ResultUtil.success();
    }

    @Override
    public Result changeOrderState(Integer goId, Byte state) {
        goodsOrderDao.updateOrderState(goId, state);
        return ResultUtil.success();
    }

    @Override
    public Result searchExpress(Integer goId) {
        GoodsOrder goodsOrder = goodsOrderDao.selectById(goId);
        if(goodsOrder == null){
            return ResultUtil.error(OrderCode.NO_ORDER);
        }
        if (goodsOrder.getOrderState() < 2){
            return ResultUtil.error(OrderCode.NO_PAY);
        }
        if(goodsOrder.getExpressNo() == null){
            return ResultUtil.error(OrderCode.NOT_DELIVER);
        }
        ExpressVO expressVO = SearchExpress.Get(goodsOrder.getExpressNo());
        if(expressVO.getMsg() != null){
            return ResultUtil.error(expressVO.getMsg());
        }
        expressVO.setMsg("");
        return ResultUtil.success(expressVO);
    }
}
