package com.tangmo.shengmei.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author boge
 * @date 18/1/9
 * @description 商品评论表
 */
@Data
public class GoodsComment implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer gcId;
    private Integer ciId;
    private Integer userId;
    private String userName;
    private String avatarId;
    private Byte belongType;
    private String comment;
}
