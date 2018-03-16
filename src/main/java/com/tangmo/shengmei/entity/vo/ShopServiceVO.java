package com.tangmo.shengmei.entity.vo;

import lombok.Data;

import java.sql.Date;

/**
 * @author boge
 * @date 18/3/17
 * @description
 */
@Data
public class ShopServiceVO {
    private static final long serialVersionUID = 1L;
    private Integer sgId;
    private Integer userId;
    private String userName;
    private String city;
    private String shopName;
    private String shopContent;
    private String imgId;
    private Byte serviceType;
    private Double price;
    private String discountNote;
    private String mobile;
    private String address;
    private Date updateTime;
}
