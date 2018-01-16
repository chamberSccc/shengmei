package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.AdminDao;
import com.tangmo.shengmei.entity.AdminInfo;
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
}
