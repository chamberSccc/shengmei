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
    private Integer uaId;
    private Integer userId;
    private Integer goCount;
    private Byte orderState;
    private String orderNumber;
    private String transNumber;


    /**物流*/
    private Double expressFee;
    private Double discountFee;
    private Double payFee;


    private Date payTime;
    private Date createTime;
    private Date updateTime;
}
