package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.CarForum;
import com.tangmo.shengmei.entity.ForumComment;
import com.tangmo.shengmei.entity.ForumStar;
import com.tangmo.shengmei.utility.code.Result;

/**
 * @author boge
 * @date 18/3/21
 * @description
 */

public interface CarForumService {

    /**
     * 增加车友圈
     *
     * @param carForum
     * @return
     */
    Result addCarForum(CarForum carForum);

    /**
     * 增加车友圈评论
     *
     * @param forumComment
     * @return
     */
    Result addForumComment(ForumComment forumComment);

    /**
     * 增加好评
     *
     * @param forumStar
     * @return
     */
    Result addForumStar(ForumStar forumStar);

    /**
     * 车友圈列表
     *
     * @param type
     * @param start
     * @param end
     * @return
     */
    Result searchForumList(Byte type, Integer start, Integer end);

    /**
     * 用户车友圈列表
     *
     * @param userId
     * @param start
     * @param end
     * @return
     */
    Result searchForumList(Integer userId, Integer start, Integer end);

    /**
     * 车友圈详情
     *
     * @param cfId
     * @return
     */
    Result searchForumDetail(Integer cfId);

    /**
     * 查询车友圈评论
     *
     * @param cfId
     * @param start
     * @param end
     * @return
     */
    Result selectForumComment(Integer cfId, Integer start, Integer end);
}
