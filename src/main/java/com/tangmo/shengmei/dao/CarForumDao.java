package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.CarForum;
import com.tangmo.shengmei.entity.ForumComment;
import com.tangmo.shengmei.entity.ForumStar;
import com.tangmo.shengmei.entity.vo.ForumCommentVO;
import com.tangmo.shengmei.entity.vo.ForumListVO;
import com.tangmo.shengmei.entity.vo.ForumDetailVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author boge
 * @date 18/3/22
 * @description 车友圈dao层
 */

public interface CarForumDao {

    /**
     * 增加车友圈
     *
     * @param carForum
     * @return
     */
    int insertCarForum(CarForum carForum);

    /**
     * 增加车友圈评论
     *
     * @param comment
     * @return
     */
    int insertForumComment(ForumComment comment);

    /**
     * 增加车友圈好评
     *
     * @param forumStar
     * @return
     */
    int insertForumStar(ForumStar forumStar);

    /**
     * 查询车友圈/视频 列表
     *
     * @param type
     * @param start
     * @param end
     * @return
     */
    List<ForumListVO> selectByType(@Param("type") Byte type,
                                   @Param("start") Integer start, @Param("end") Integer end);

    /**
     * 查询用户车友圈/视频 列表
     *
     * @param userId
     * @param start
     * @param end
     * @return
     */
    List<ForumListVO> selectByTypeAndUser(@Param("userId") Integer userId,
                                          @Param("start") Integer start, @Param("end") Integer end);

    /**
     * 增加浏览次数
     *
     * @param cfId
     * @return
     */
    int updateViewCount(Integer cfId);

    /**
     * 增加详情
     *
     * @param cfId
     * @return
     */
    ForumDetailVO selectById(Integer cfId);

    /**
     * 查询车友圈评论
     *
     * @param cfId
     * @param start
     * @param end
     * @return
     */
    List<ForumCommentVO> selectForumComment(@Param("cfId") Integer cfId, @Param("start") Integer start,
                                            @Param("end") Integer end);
}
