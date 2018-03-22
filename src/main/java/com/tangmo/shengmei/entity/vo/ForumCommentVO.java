package com.tangmo.shengmei.entity.vo;

import lombok.Data;

import java.sql.Date;

/**
 * @author boge
 * @date 18/3/22
 * @description
 */
@Data
public class ForumCommentVO {

    private Integer userId;
    private String userName;
    private String avatarId;
    private String content;
    private Date createTime;
}
