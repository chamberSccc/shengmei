package com.tangmo.shengmei.entity;

import lombok.Data;

/**
 * @author boge
 * @date 18/3/21
 * @description 车友圈
 */
@Data
public class CarForum {
    private Integer cfId;
    private Integer userId;
    private String mediaId;
    private String content;
    private Byte cfType;
}
