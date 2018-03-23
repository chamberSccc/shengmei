package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.CarForumDao;
import com.tangmo.shengmei.entity.CarForum;
import com.tangmo.shengmei.entity.ForumComment;
import com.tangmo.shengmei.entity.ForumStar;
import com.tangmo.shengmei.service.CarForumService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author boge
 * @date 18/3/21
 * @description
 */
@Service("carForumService")
public class CarForumServiceImpl implements CarForumService{
    @Resource
    private CarForumDao carForumDao;
    @Override
    public Result addCarForum(CarForum carForum) {
        if(carForum.getCfType() == null || carForum.getUserId() == null){
            return ResultUtil.paramError();
        }
        carForumDao.insertCarForum(carForum);
        return ResultUtil.success();
    }

    @Override
    public Result addForumComment(ForumComment forumComment) {
        carForumDao.insertForumComment(forumComment);
        return ResultUtil.success();
    }

    @Override
    public Result addForumStar(ForumStar forumStar) {
        if(forumStar.getUserId() == null || forumStar.getCfId() == null){
            return ResultUtil.paramError();
        }
        carForumDao.insertForumStar(forumStar);
        return ResultUtil.success();
    }

    @Override
    public Result searchForumList(Byte type, Integer start, Integer end) {
        return ResultUtil.success(carForumDao.selectByType(type, start, end));
    }

    @Override
    public Result searchForumList(Integer userId, Integer start, Integer end) {
        return ResultUtil.success(carForumDao.selectByTypeAndUser(userId, start, end));
    }

    @Override
    public Result searchForumDetail(Integer cfId) {
        carForumDao.updateViewCount(cfId);
        return ResultUtil.success(carForumDao.selectById(cfId));
    }

    @Override
    public Result selectForumComment(Integer cfId, Integer start, Integer end) {
        return ResultUtil.success(carForumDao.selectForumComment(cfId,start,end));
    }
}
