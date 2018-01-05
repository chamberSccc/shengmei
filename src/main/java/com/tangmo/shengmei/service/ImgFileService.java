package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.RsFile;
import org.springframework.http.ResponseEntity;

/**
 * @author boge
 * @date 17/12/22
 * @description 文件服务
 */

public interface ImgFileService {

    /**
     * 增加图片文件,并存储
     *
     * @param code   图像base64编码
     * @param userId 用户id
     * @return
     */
    RsFile addImgFile(String code, Integer userId);

    /**
     * 查找文件路径
     *
     * @param fileId 文件名
     * @return
     */
    String getImgFilePath(String fileId);


    ResponseEntity<byte[]> downloadFile(String rfId, String userAgent);
}
