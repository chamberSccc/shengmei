package com.tangmo.shengmei.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @author boge
 * @date 18/3/8
 * @description
 */
@Data
public class GoodsOrder {
    private Integer goId;
    private Integer cdId;
    private Integer uaId;
    private Integer userId;
    private Integer merchantId;
    private Integer goCount;
    private Byte orderState;
    private String orderNumber;
    private String transNumber;
    private Double goodsPrice;


    /**物流*/
    private Double expressFee;
    private Double discountFee;
    private Double payFee;
    private String expressNo;


    private Date payTime;
    private Date createTime;
    private Date updateTime;

    /**商品信息*/
    private String imgId;
    private String title;
    private String content;
    private String cdSize;
    private String cdColor;

    private UserAddress address;
}
