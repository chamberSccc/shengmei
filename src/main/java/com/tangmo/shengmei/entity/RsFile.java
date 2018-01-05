package com.tangmo.shengmei.entity;

import lombok.Data;

/**
 * @author boge
 * @date 17/12/22
 * @description 文件资源实体类
 */

@Data
public class RsFile {
    private String fileId;
    private String path;
    private Integer userId;
}
