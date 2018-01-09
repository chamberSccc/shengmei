package com.tangmo.shengmei.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * @author boge
 * @date 17/12/22
 * @description 便民信息实体类PO
 */

@Data
public class ConvInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer ciId;
    private Integer userId;
    private Integer username;
    private Integer avatarId;
    private String title;
    private String subtitle;
    private String content;
    private Integer viewCount;
    private Integer commentCount;
    private Date createTime;
    private Date updateTime;
    private List<ConvComment> commentList;
}
