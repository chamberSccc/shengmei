package com.tangmo.shengmei.entity.vo;

import lombok.Data;

import java.sql.Date;

/**
 * @author boge
 * @date 18/3/22
 * @description 车友圈/视频列表vo
 */
@Data
public class ForumListVO {
    private Integer cfId;
    private Integer userId;
    private String userName;
    private String avatarId;
    private Integer viewCount;
    private Integer starCount;
    private Integer commentCount;
    private String content;
    private String mediaId;
    private String imgList;
    private Date createTime;
}
