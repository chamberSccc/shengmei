package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.ShopVerifyDao;
import com.tangmo.shengmei.entity.ShopVerify;
import com.tangmo.shengmei.service.ImgFileService;
import com.tangmo.shengmei.service.ShopVerifyService;
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
 * @date 18/3/9
 * @description
 */
@Service("shopVerifyService")
public class ShopVerifyServiceImpl implements ShopVerifyService {
    @Resource
    private ShopVerifyDao shopVerifyDao;

    private static final Byte NOT_VERIFY = 0;
    private static final Byte VERIFY = 1;

    @Override
    @Transactional
    public Result addShopVerify(ShopVerify shopVerify) {
        if(shopVerify.getUserId() == null || shopVerify.getIdNumber() == null || shopVerify.getShopAddress() == null){
            return ResultUtil.error("信息不完整");
        }
        if(shopVerify.getShopIntro() == null || shopVerify.getShopName() == null){
            return ResultUtil.error("信息不完整");
        }
        //先判断是否有审核信息
        ShopVerify result = shopVerifyDao.selectByUserId(shopVerify.getUserId());
        if(result != null){
            return ResultUtil.error("已存在审核信息");
        }
        shopVerify.setShopState(NOT_VERIFY);
        shopVerifyDao.insertShopVerify(shopVerify);
        return ResultUtil.success();
    }

    @Override
    public Result searchSvInfo(Integer userId) {
        return ResultUtil.success(shopVerifyDao.selectByUserId(userId));
    }

    @Override
    public Result searchAllSvInfo(Integer start, Integer end) {
        return ResultUtil.success(shopVerifyDao.selectAll(start, end));
    }

    @Override
    public Result searchSvInfo(Byte state,Integer start, Integer end) {
        return ResultUtil.success(shopVerifyDao.selectByState(state, start, end));
    }

    @Override
    public Result searchSvInfo(Byte state, Page page) {
        if(page == null){
            return ResultUtil.fail();
        }
        page.startPage();
        List<ShopVerify> list = shopVerifyDao.selectPageByState(state);
        page.setResult(list);
        return page;
    }

    @Override
    public Result changeSvInfo(ShopVerify shopVerify) {
        shopVerifyDao.updateSvInfo(shopVerify);
        return ResultUtil.success();
    }

    @Override
    public Result updateSvState(Integer svId, Byte state) {
        shopVerifyDao.updateSvState(svId, state);
        return ResultUtil.success();
    }
}
