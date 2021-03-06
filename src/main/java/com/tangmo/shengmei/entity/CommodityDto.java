package com.tangmo.shengmei.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author boge
 * @date 18/1/10
 * @description 商品查询对象
 */
@Data
public class CommodityDto{

    private Byte cdType;
    private Byte cdClass;
    private Boolean star;
    private Double priceStart;
    private Double priceEnd;
    private Byte price;
    private String city;
    private String district;
    private Integer start;
    private Integer end;

}
