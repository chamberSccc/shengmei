package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.File;
import com.tangmo.shengmei.utility.code.Result;

/**
 * @author boge
 * @date 17/12/22
 * @description 文件服务
 */

public interface FileService {

    /**
     * 增加文件
     *
     * @param file 文件对象
     * @return
     */
    File addFile(File file);

    /**
     * 查找文件路径
     *
     * @param fileId
     * @return
     */
    String getFilePath(String fileId);
}
