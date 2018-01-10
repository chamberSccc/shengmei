package com.tangmo.shengmei.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author boge
 * @date 17/12/25
 * @description 商品信息实体类PO
 */
@Data
public class Commodity implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer cdId;
    private Integer userId;
    private String imgId;
    private String title;
    private String content;
    private Byte cdType;
    private Integer cdCount;
    private Double pricePre;
    private Double priceNow;
    private String cdColor;
    private String cdSize;
    private Byte isQuality;
    private Byte isSell;
    private String province;
    private String city;
    private String district;
    private Byte cdClass;
    private Integer star;
    private Date createTime;
    private Date updateTime;
}
