package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.CarForum;
import com.tangmo.shengmei.entity.ForumComment;
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
}
