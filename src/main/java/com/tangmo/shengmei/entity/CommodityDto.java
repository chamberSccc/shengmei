package com.tangmo.shengmei.entity;

import lombok.Data;

/**
 * @author boge
 * @date 18/1/10
 * @description 商品查询对象
 */
@Data
public class CommodityDto {

    private static final long serialVersionUID = 1L;
    private Byte cdClass;
    private Integer star;
    private Double priceNow;
    private String province;
    private String city;
    private String district;

}
