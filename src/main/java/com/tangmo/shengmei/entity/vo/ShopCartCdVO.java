package com.tangmo.shengmei.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author boge
 * @date 18/3/15
 * @description
 */
@Data
public class ShopCartCdVO implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer cdId;
    private Integer userId;
    private String imgId;
    private String title;
    private Integer cdType;
    private Double priceNow;
}
