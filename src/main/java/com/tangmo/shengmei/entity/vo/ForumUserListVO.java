package com.tangmo.shengmei.entity.vo;

import lombok.Data;

import java.sql.Date;

/**
 * @author boge
 * @date 18/3/22
 * @description
 */
@Data
public class ForumUserListVO {
    private Integer cfId;
    private Integer viewCount;
    private Integer starCount;
    private Integer commentCount;
    private String content;
    private Byte cfType;
    private String mediaId;
    private String imgList;
    private Date createTime;
}
