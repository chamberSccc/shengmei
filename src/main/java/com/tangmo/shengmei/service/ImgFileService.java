package com.tangmo.shengmei.service;

import org.springframework.http.ResponseEntity;

/**
 * @author boge
 * @date 17/12/22
 * @description 文件服务
 */

public interface ImgFileService {

    /**
     * 增加文件
     *
     * @param code 图像base64编码
     * @param userId 用户id
     * @return
     */
    Boolean addImgFile(Integer userId);

    /**
     * 查找文件路径
     *
     * @param fileId 文件名
     * @return
     */
    String getImgFilePath(String fileId);


    ResponseEntity<byte[]> downloadFile(String rfId, String userAgent);
}
