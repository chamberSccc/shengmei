package com.tangmo.shengmei.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @author Chamber
 * @date 2018/3/8. 订单列表展示信息
 */
@Data
public class GoodsOrderSimple {

    private Integer goId;
    private Integer cdId;
    private Integer uaId;
    private Integer userId;
    private Byte orderState;
    private String orderNumber;
    private Integer goCount;
    private String cdSize;
    private String cdColor;
    private Double expressFee;
    private Double discountFee;
    private Double payFee;
    /**商品信息*/
    private String imgId;
    private String title;
    private String content;

}
