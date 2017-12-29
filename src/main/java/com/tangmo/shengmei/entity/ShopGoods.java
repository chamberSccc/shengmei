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
    private Integer usId;
    private String goodsName;
    private String goodsContent;
    private String imgId;
    private Byte goodsType;
    private Double goodsPrice;
    private Date createTime;
    private Date updateTime;
}
