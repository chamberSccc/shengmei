package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.MyCollect;
import com.tangmo.shengmei.utility.code.Result;

/**
 * @author boge
 * @date 17/12/29
 * @description 我的收藏服务接口
 */

public interface MyCollectService {

    /**
     * 新增我的收藏
     *
     * @param myCollect 我的收藏实体类
     * @return
     */
    Result addMyCollect(MyCollect myCollect);

    /**
     * 删除我的收藏
     *
     * @param mcId 我的收藏主键id
     * @return
     */
    Result delMyCollect(Integer mcId);

    /**
     * 查找用户我的收藏信息
     *
     * @param userId 用户Id
     * @param start  开始索引
     * @param end    结束索引
     * @return
     */
    Result searchMyCollect(Integer userId, Integer start, Integer end);
}
