package com.tangmo.shengmei.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author boge
 * @date 17/12/29
 * @description 店铺商品PO
 */
@Data
public class ShopGoods implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer sgId;
    private Integer userId;
    private String shopName;
    private String shopContent;
    private String imgId;
    private Byte serviceType;
    private Double price;
    private String discountNote;
    private String mobile;
    private String address;
    private Date createTime;
    private Date updateTime;
}
