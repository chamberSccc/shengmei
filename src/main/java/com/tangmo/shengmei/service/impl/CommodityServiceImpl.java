package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.constant.GoodsBelongConst;
import com.tangmo.shengmei.dao.CommodityDao;
import com.tangmo.shengmei.dao.ShopGoodsDao;
import com.tangmo.shengmei.entity.Commodity;
import com.tangmo.shengmei.entity.GoodsComment;
import com.tangmo.shengmei.entity.RsFile;
import com.tangmo.shengmei.service.CommodityService;
import com.tangmo.shengmei.service.ImgFileService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import com.tangmo.shengmei.utility.file.ImgUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

/**
 * @author boge
 * @date 17/12/27
 * @description 商品服务实现类
 */
@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {
    @Resource
    private CommodityDao commodityDao;
    @Resource
    private ShopGoodsDao shopGoodsDao;
    @Resource
    private ImgFileService imgFileService;

    @Override
    @Transactional
    public Result addCommodity(Commodity commodity) {
        if (commodity.getPriceNow() == null || commodity.getCdType() == null || commodity.getUserId() == null) {
            return ResultUtil.fail();
        }
        //先处理图片
        if(commodity.getImgId() != null){
            RsFile rsFile = imgFileService.addImgFile(commodity.getImgId(),commodity.getUserId());
            if(rsFile == null){
                return ResultUtil.fail();
            }
            commodity.setImgId(rsFile.getFileId());
        }
        commodityDao.insertSelective(commodity);
        return ResultUtil.success();
    }

    @Override
    @Transactional
    public Result changeCommodity(Commodity commodity) {
        if (commodity.getCdId() == null) {
            return ResultUtil.fail();
        }
        if(commodity.getImgId()!=null || commodity.getUserId()!=null){
            //先处理图片
            RsFile rsFile = imgFileService.addImgFile(commodity.getImgId(),commodity.getUserId());
            if(rsFile == null){
                return ResultUtil.fail();
            }
            commodity.setImgId(rsFile.getFileId());
        }
        commodityDao.updateById(commodity);
        return ResultUtil.success();
    }

    @Override
    public Result searchCdList(Byte cdType, Integer start, Integer end) {
        return ResultUtil.success(commodityDao.selectListByType(cdType, start, end));
    }

    @Override
    public Result searchUserCdList(Integer userId) {
        return ResultUtil.success(commodityDao.selectListByUserId(userId));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result delCommodity(Integer cdId) {
        commodityDao.deleteById(cdId);
        return ResultUtil.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addComment(GoodsComment goodsComment) {
        commodityDao.insertComment(goodsComment);
        return ResultUtil.success();
    }

    @Override
    public Result getComments(Integer goodsId, Byte belongType, Integer start, Integer end) {
        if(belongType.equals(GoodsBelongConst.PERSON_GOODS)){
            return ResultUtil.success(commodityDao.selectCommentByGoodsId(goodsId,start,end));
        }else if(belongType.equals(GoodsBelongConst.SHOP_GOODS)){
            return ResultUtil.success(shopGoodsDao.selectCommentByGoodsId(goodsId, start, end));
        }else{
            return ResultUtil.fail();
        }
    }

    @Override
    public Result getCommodityDetail(Integer userId,Integer cdId) {
        return null;
    }
}
