package com.tangmo.shengmei.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author boge
 * @date 18/1/9
 * @description 商品评论表
 */
@Data
public class GoodsComment implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer gcId;
    private Integer goodsId;
    private Integer userId;
    private String username;
    private String avatarId;
    private Byte belongType;
    private String comment;

    /**
     * 评价指标相关
     */
    private Byte goodsWrapper;
    private Byte expressSpeed;
    private Byte deliverAtti;
    private Byte isAnonymous;
    private Date createTime;
}
