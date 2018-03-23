package com.tangmo.shengmei.entity;

import lombok.Data;

/**
 * @author boge
 * @date 18/3/17
 * @description
 */
@Data
public class ShopServiceDto {
    private Byte type;
    private Double priceStart;
    private Double priceEnd;
    private Byte price;
    private String city;
    private Integer start;
    private Integer end;
}
