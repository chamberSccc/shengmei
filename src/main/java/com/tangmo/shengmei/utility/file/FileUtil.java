package com.tangmo.shengmei.utility.file;

import com.tangmo.shengmei.entity.File;
import com.tangmo.shengmei.utility.string.Base64Util;
import com.tangmo.shengmei.utility.string.EncryptUtil;

/**
 * @author boge
 * @date 17/12/22
 * @description 文件工具类
 */

public class FileUtil {

    /**
     * 图片存储到硬盘上
     *
     * @param file 文件实体类
     * @param code 图片base64code
     * @return
     */
    public static Boolean saveImg2Disk(File file, String code) {
        String dir = "";
//        String dir = env.getProperty("RF.BASE_DIR");
        byte[] bytes = Base64Util.decryptCode(code);
        StringBuilder sb = new StringBuilder(dir).append("/").append(file.getPath());
        return Base64Util.code2Image(bytes, sb.toString());
    }

    /**
     * 根据用户id,获取文件具体信息 32位主键编码和存放路径
     *
     * @param userId 用户id
     * @param fileType 文件类型
     * @return
     */
    public static File getFileInfo(Integer userId, String fileType) {
        String uuid = EncryptUtil.get32Uuid();
        StringBuilder sb = new StringBuilder("").append("/").append(userId).append("/")
                .append(uuid).append(".").append(fileType);
        File file = new File();
        file.setFileId(uuid);
        file.setPath(sb.toString());
        return file;
    }
}
