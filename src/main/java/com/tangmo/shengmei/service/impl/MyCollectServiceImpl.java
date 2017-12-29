package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.MyCollectDao;
import com.tangmo.shengmei.entity.MyCollect;
import com.tangmo.shengmei.service.MyCollectService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author boge
 * @date 17/12/29
 * @description 我的收藏服务类收藏
 */
@Service("myCollectService")
public class MyCollectServiceImpl implements MyCollectService {

    @Resource
    private MyCollectDao myCollectDao;

    @Override
    @Transactional
    public Result addMyCollect(MyCollect myCollect) {
        if (myCollect.getUserId() == null || myCollect.getCdId() == null) {
            return ResultUtil.fail();
        }
        myCollectDao.insertSelective(myCollect);
        return ResultUtil.success();
    }

    @Override
    @Transactional
    public Result delMyCollect(Integer mcId) {
        myCollectDao.deleteById(mcId);
        return ResultUtil.success();
    }

    @Override
    public Result searchMyCollect(Integer userId, Integer start, Integer end) {
        return ResultUtil.success(myCollectDao.selectListByUserId(userId, start, end));
    }

}
