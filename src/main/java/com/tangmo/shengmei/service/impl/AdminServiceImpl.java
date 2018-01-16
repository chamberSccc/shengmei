package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.AdminDao;
import com.tangmo.shengmei.dao.CommonDao;
import com.tangmo.shengmei.entity.AdminInfo;
import com.tangmo.shengmei.entity.GoodsTypeItem;
import com.tangmo.shengmei.service.AdminService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author boge
 * @date 18/1/11
 * @description 管理员服务实现类
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;
    @Resource
    private CommonDao commonDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addAdmin(AdminInfo adminInfo) {
        if (adminInfo.getAccount() == null || adminInfo.getPassword() == null) {
            return ResultUtil.fail();
        }
        adminDao.insertAdmin(adminInfo);
        return ResultUtil.success();
    }

    @Override
    public Result adminLogin(AdminInfo adminInfo) {
        if (adminInfo.getAccount() == null || adminInfo.getPassword() == null) {
            return ResultUtil.fail();
        }
        AdminInfo checkAdmin = adminDao.selectByAccount(adminInfo.getAccount());
        if(!checkAdmin.getPassword().equals(adminInfo.getPassword())){
            return ResultUtil.pwdError();
        }
        return ResultUtil.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addGoodsTypeItem(GoodsTypeItem goodsTypeItem) {
        if(goodsTypeItem.getGtId()==null || goodsTypeItem.getValue()==null || goodsTypeItem.getName()==null){
            return ResultUtil.fail();
        }
        Integer maxItemValue = commonDao.selectMaxItemValue(goodsTypeItem.getGtId());
        goodsTypeItem.setValue((byte) (maxItemValue+1));
        return ResultUtil.success();
    }

    @Override
    public Result changeGoodsTypeItem(GoodsTypeItem goodsTypeItem) {
        if(goodsTypeItem.getId() == null || goodsTypeItem.getName() == null){
            return ResultUtil.fail();
        }
        commonDao.updateGoodsTypeItem(goodsTypeItem);
        return null;
    }

    @Override
    public Result delGoodsTypeItem(Integer id) {
        commonDao.deleteGoodsTypeItem(id);
        return ResultUtil.success();
    }

    @Override
    public Result searchGoodsTypeItem(Byte gtId) {
        return ResultUtil.success(commonDao.selectItemByType(gtId));
    }

    @Override
    public Result searchGoodsType() {
        return ResultUtil.success(commonDao.selectGoodsType());
    }
}
