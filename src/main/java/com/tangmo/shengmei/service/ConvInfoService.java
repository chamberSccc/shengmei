package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.ConvComment;
import com.tangmo.shengmei.entity.ConvInfo;
import com.tangmo.shengmei.utility.code.Result;

/**
 * @author boge
 * @date 17/12/22
 * @description 便民信息服务
 */

public interface ConvInfoService {

    /**
     * 增加便民信息
     *
     * @param convInfo
     * @return
     */
    Result addConvInfo(ConvInfo convInfo);

    /**
     * 修改便民信息
     *
     * @param convInfo
     * @return
     */
    Result changeConvInfo(ConvInfo convInfo);

    /**
     * 获取分页便民信息列表
     *
     * @param start
     * @param end
     * @return
     */
    Result searchConvList(Integer start, Integer end);

    /**
     * 查询便民信息详细信息
     *
     * @param ciId 便民信息主键id
     * @return
     */
    Result searchConvDetail(Integer ciId);

    /**
     * 增加便民信息评论
     *
     * @param convComment 便民评论对象
     * @return
     */
    Result addComment(ConvComment convComment);
}
