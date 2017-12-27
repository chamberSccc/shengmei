package com.tangmo.shengmei.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author boge
 * @date 17/12/27
 * @description 用户购物车PO
 */
@Data
public class ShopCart implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer scId;
    private Integer userId;
    private Integer cdId;
    private Double price;
    private Integer payCount;
    private Commodity commodity;
}
