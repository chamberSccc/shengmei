package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.File;

/**
 * @author boge
 * @date 17/12/22
 * @description 文件信息Dao接口
 */

public interface FileDao {

    /**
     * 增加文件信息
     *
     * @param file
     * @return
     */
    File insertFile(File file);

    /**
     * 查询文件路径信息
     *
     * @param fileId
     * @return
     */
    String selectById(String fileId);
}
