package com.tangmo.shengmei.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author boge
 * @date 18/4/11
 * @description 车友圈关注Dao
 */
@Mapper
public interface ForumFollowDao {

    /**
     * 增加车友圈关注
     *
     * @param userId
     * @param forumId
     * @return
     */
    int insertFollow(@Param("userId") Integer userId, @Param("forumId") Integer forumId);

    /**
     * 删除车友圈关注
     *
     * @param userId
     * @param forumId
     * @return
     */
    int deleteFollow(@Param("userId") Integer userId, @Param("forumId") Integer forumId);

    /**
     * 查询车友圈关注
     *
     * @param userId
     * @param forumId
     * @return
     */
    Integer selectFollow(@Param("userId") Integer userId, @Param("forumId") Integer forumId);
}
