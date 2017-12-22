package com.tangmo.shengmei.utility.string;

import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Chamber
 * @create 2017-08-16
 * @description 图片base64解析,加密
 */
public class Base64Util {

    /**
     * 解析base64字符串为图片byte
     * @param code base字符串
     * @return
     */
    public static byte[] decryptCode(String code) {

        if (code == null) {
            return null;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            return decoder.decodeBuffer(code);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 图片byte数据转为图像,并存储
     * @param bytes 字符串
     * @param path 存储路径
     * @return
     */
    public static boolean code2Image(byte[] bytes, String path) {

        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] < 0) {
                bytes[i] += 256;
            }
        }

        try {
            File fileDir = new File(path);
            if(!fileDir.getParentFile().exists()) {
                boolean mkdirs = fileDir.getParentFile().mkdirs();
                if (!mkdirs) {
                    return false;
                }
            }
            OutputStream out = new FileOutputStream(path);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
