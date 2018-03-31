package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.IllegalHandle;

/**
 * @author boge
 * @date 18/3/30
 * @description
 */

public interface IllegalHandleDao {

    /**
     * 增加违章代缴信息
     *
     * @return
     */
    int insertIllegalHandle(IllegalHandle illegalHandle);

    /**
     * 修改违章代缴信息
     *
     * @param illegalHandle
     * @return
     */
    int updateByOutTradeNo(IllegalHandle illegalHandle);

    /**
     * 查询违章代缴信息
     *
     * @param outOrderNo
     * @return
     */
    IllegalHandle selectByOutTradeNo(String outOrderNo);
}
