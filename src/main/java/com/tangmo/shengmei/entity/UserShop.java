package com.tangmo.shengmei.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author boge
 * @date 17/12/29
 * @description 用户店铺实体类PO
 */
@Data
public class UserShop implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer usId;
    private Integer userId;
    private String mobile;
    private String us_province;
    private String us_city;
    private String us_district;
    private String imgId;
    private Byte isAuth;
}
