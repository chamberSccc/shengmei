package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.ShopVerifyDao;
import com.tangmo.shengmei.entity.ShopVerify;
import com.tangmo.shengmei.service.ImgFileService;
import com.tangmo.shengmei.service.ShopVerifyService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author boge
 * @date 18/3/9
 * @description
 */
@Service("shopVerifyService")
public class ShopVerifyServiceImpl implements ShopVerifyService {
    @Resource
    private ImgFileService imgFileService;
    @Resource
    private ShopVerifyDao shopVerifyDao;

    private static final Byte NOT_VERIFY = 0;
    private static final Byte VERIFY = 1;

    @Override
    @Transactional
    public Result addShopVerify(ShopVerify shopVerify, MultipartFile idFront, MultipartFile idRear,
                                MultipartFile logo, MultipartFile license) {
        if(shopVerify.getUserId() == null || shopVerify.getIdNumber() == null || shopVerify.getShopAddress() == null){
            return ResultUtil.paramError();
        }
        if(shopVerify.getShopIntro() == null || shopVerify.getShopName() == null){
            return ResultUtil.paramError();
        }
        //先判断是否有审核信息
        ShopVerify result = shopVerifyDao.selectByUserId(shopVerify.getUserId());
        if(result != null){
            return ResultUtil.existInfo();
        }
        //身份证正反面照片处理
        String frontUuid = imgFileService.uploadFile(idFront,shopVerify.getUserId());
        if(frontUuid == null){
            return ResultUtil.fail();
        }
        shopVerify.setIdFrontImg(frontUuid);
        String rearUuid = imgFileService.uploadFile(idRear,shopVerify.getUserId());
        if(rearUuid == null){
            return ResultUtil.fail();
        }
        shopVerify.setIdRearImg(rearUuid);
        //logo和营业执照照片处理
        String logoUuid = imgFileService.uploadFile(logo,shopVerify.getUserId());
        if(logoUuid == null){
            return ResultUtil.fail();
        }
        shopVerify.setLogoImg(logoUuid);
        String licenseUuid = imgFileService.uploadFile(license,shopVerify.getUserId());
        if(licenseUuid == null){
            return ResultUtil.fail();
        }
        shopVerify.setLicenseImg(licenseUuid);
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
}
