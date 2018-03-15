package com.tangmo.shengmei.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author boge
 * @date 18/3/13
 * @description 店铺服务列表简要信息vo
 */
@Data
public class SimpleShopGoodsVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer sgId;
    private String shopName;
    private String shopContent;
    private String imgId;
    private Byte serviceType;
    private String address;
    private Double price;
}
