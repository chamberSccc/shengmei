package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.constant.GoodsBelongConst;
import com.tangmo.shengmei.dao.CommodityDao;
import com.tangmo.shengmei.dao.ShopGoodsDao;
import com.tangmo.shengmei.dao.UserDao;
import com.tangmo.shengmei.entity.*;
import com.tangmo.shengmei.service.CommodityService;
import com.tangmo.shengmei.service.ImgFileService;
import com.tangmo.shengmei.utility.code.Page;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

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
    private UserDao userDao;
    @Resource
    private ImgFileService imgFileService;

    @Override
    @Transactional
    public Result addCommodity(Commodity commodity) {
        if (commodity.getPriceNow() == null || commodity.getCdType() == null) {
            return ResultUtil.error("请确认价格,商品类型是否填写");
        }
        if (commodity.getUserId() == null) {
            return ResultUtil.error("暂无该用户信息");
        }
        if(commodity.getImgId() == null){
            return ResultUtil.error("请确认是否已上传图片");
        }
        commodityDao.insertSelective(commodity);
        return ResultUtil.success();
    }

    @Override
    public Result addCdImg(Integer userId,MultipartFile file) {
        return imgFileService.uploadImg(userId, file);
    }

    @Override
    @Transactional
    public Result changeCommodity(Commodity commodity,MultipartFile file) {
        if (commodity.getCdId() == null) {
            return ResultUtil.fail();
        }
        if(file!=null){
            String uuid = imgFileService.uploadFile(file,commodity.getUserId());
            if(uuid == null){
                return ResultUtil.fail();
            }
            commodity.setImgId(uuid);
        }
        commodityDao.updateById(commodity);
        return ResultUtil.success();
    }

    @Override
    public Result searchCdList(Byte cdType, Integer start, Integer end) {
        return ResultUtil.success(commodityDao.selectListByType(cdType, start, end));
    }

    @Override
    public Result searchCdList(Byte cdType, Page page) {
        if(page == null){
            return ResultUtil.fail();
        }
        page.startPage();
        List<Commodity> list = commodityDao.selectPageByType(cdType);
        page.setResult(list);
        return page;
    }

    @Override
    public Result searchUserCdList(Integer userId, Integer start, Integer end) {
        return ResultUtil.success(commodityDao.selectListByUserId(userId,start,end));
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
        if(goodsComment.getIsAnonymous() == 1){
            goodsComment.setUserId(null);
        }
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
        if(userId != null){
            //增加浏览记录
            ViewRecord viewRecord = new ViewRecord(userId,cdId,GoodsBelongConst.PERSON_GOODS);
            userDao.insertViewRecord(viewRecord);
        }
        return ResultUtil.success(commodityDao.selectCommodityDetail(cdId));
    }

    @Override
    public Result getQualityInfo(Integer start, Integer end) {
        return ResultUtil.success(commodityDao.selectQualityList(start, end));
    }

    @Override
    public Result getViewRecord(Integer userId, Integer start, Integer end) {
        return ResultUtil.success(commodityDao.selectViewRecord(userId, start, end));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result delViewRecord(Integer vrId) {
        commodityDao.deleteViewRecordById(vrId);
        return ResultUtil.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result delMultiViewRecord(Integer[] vrIds) {
        commodityDao.deleteMultiViewRecord(vrIds);
        return ResultUtil.success();
    }

    @Override
    public Result selectByCondition(CommodityDto commodityDto) {
        if(commodityDto.getEnd() == null || commodityDto.getStart() == null){
            return ResultUtil.error("无分页信息");
        }
        if(commodityDto.getCdType() == null){
            return ResultUtil.error("无商品类型信息");
        }
        return ResultUtil.success(commodityDao.selectCdByCondition(commodityDto));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addCdStar(Integer cdId, Integer userId) {
        commodityDao.updateCdStar(cdId);
        return ResultUtil.success();
    }

    @Override
    public Result searchTypeQualityList(Byte type, Integer start, Integer end) {
        return ResultUtil.success(commodityDao.selectQualityListByType(type, start, end));
    }

    @Override
    public Result searchTypeStarList(Byte type, Integer start, Integer end) {
        return ResultUtil.success(commodityDao.selectStarListByType(type, start, end));
    }

    @Override
    public Result emptyViewRecord(Integer userId) {
        commodityDao.deleteVrByUserId(userId);
        return ResultUtil.success();
    }

    @Override
    public Result changeCdState(Integer cdId, Byte state) {
        commodityDao.updateCdState(cdId,state);
        return ResultUtil.success();
    }

    @Override
    public Result searchSellRecord(Integer userId, Byte state, Integer start, Integer end) {
        return ResultUtil.success(commodityDao.selectCdManageRecord(userId,state, start, end));
    }

    private String[] thansImgToArray(String src){
        if(src == null){
            return new String[]{};
        }
        String[] list = src.split(",");
        return list;
    }
}
