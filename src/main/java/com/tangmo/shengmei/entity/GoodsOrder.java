package com.tangmo.shengmei.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @author Chamber
 * @date 2018/3/8.
 */
@Data
public class GoodsOrder {

    private Integer goId;
    private Integer cdId;
    private Integer goCount;
    private Byte orderState;
    private String orderNumber;
    private String transNumber;
    private Integer uaId;

    /**物流*/
    private Double expressFee;

    private Double discountFee;
    private Double payFee;

    /**评价相关*/
    private Integer gcId;
    private Byte goodsWrapper;
    private Byte expressSpeed;
    private Byte deliverAtti;
    private Byte isAnonymous;

    private Date payTime;
    private Date createTime;
    private Date updateTime;
}
