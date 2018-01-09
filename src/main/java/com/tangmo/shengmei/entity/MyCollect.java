package com.tangmo.shengmei.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author boge
 * @date 17/12/29
 * @description 我的收藏实体类PO
 */
@Data
public class MyCollect implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer mcId;
    private Integer cdId;
    private Integer userId;
    private String imgId;
    private String title;
    private String content;
    private Byte cdType;
    private Double pricePre;
    private Double priceNow;
    private Date createTime;
}
