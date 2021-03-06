package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.ConvInfoDao;
import com.tangmo.shengmei.entity.ConvComment;
import com.tangmo.shengmei.entity.ConvInfo;
import com.tangmo.shengmei.service.ConvInfoService;
import com.tangmo.shengmei.utility.code.Page;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author boge
 * @date 17/12/22
 * @description
 */

@Service("convInfoService")
public class ConvInfoServiceImpl implements ConvInfoService {
    @Resource
    private ConvInfoDao convInfoDao;

    @Override
    @Transactional
    public Result addConvInfo(ConvInfo convInfo) {
        if(convInfo.getUserId() == null){
            return ResultUtil.fail();
        }
        convInfoDao.insertSelective(convInfo);
        return ResultUtil.success();
    }

    @Override
    @Transactional
    public Result changeConvInfo(ConvInfo convInfo) {
        if(convInfo.getCiId() == null){
            return ResultUtil.fail();
        }
        convInfoDao.updateById(convInfo);
        return ResultUtil.success();
    }

    @Override
    public Result searchConvList(Integer start, Integer end) {
        return ResultUtil.success(convInfoDao.selectConvList(start,end));
    }

    @Override
    public Result searchConvList(Byte type, Page page) {
        if(page == null){
            return ResultUtil.success();
        }
        page.startPage();
        List<ConvInfo> list = convInfoDao.selectPageConv(type);
        page.setResult(list);
        return page;
    }

    @Override
    public Result searchConvDetail(Integer ciId) {
        convInfoDao.updateViewCount(ciId);
        return ResultUtil.success(convInfoDao.selectByCiId(ciId));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addComment(ConvComment convComment) {
        if(convComment.getUserId()==null || convComment.getCiId() ==null){
            return ResultUtil.fail();
        }
        convInfoDao.updateCommentCount(convComment.getCiId());
        convInfoDao.insertConvComment(convComment);
        return ResultUtil.success();
    }

    @Override
    public Result deleteConvInfo(Integer ciId) {
        convInfoDao.deleteById(ciId);
        return ResultUtil.success();
    }

    @Override
    public Result getCommentList(Integer ciId, Integer start, Integer end) {
        return ResultUtil.success(convInfoDao.selectCommentByCiId(ciId,start,end));
    }

    @Override
    public Result getUserConvInfo(Integer userId, Integer start, Integer end) {
        return ResultUtil.success(convInfoDao.selectByUserId(userId, start, end));
    }

    @Override
    public Result getConvInfoByExpire(Integer type, Integer start, Integer end) {
        return ResultUtil.success(convInfoDao.selectByIsExpire(type, start, end));
    }
}
