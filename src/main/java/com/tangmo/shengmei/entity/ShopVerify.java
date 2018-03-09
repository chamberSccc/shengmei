package com.tangmo.shengmei.entity;

import lombok.Data;

/**
 * @author boge
 * @date 18/3/9
 * @description 商家审核实体类
 */
@Data
public class ShopVerify {

    private Integer svId;
    private Integer userId;
    private String mobile;
    private String userName;
    private String idNumber;
    private String idFrontImg;
    private String idRearImg;
    private String shopName;
    private String logoImg;
    private String shopIntro;
    private String shopAddress;
    private String licenseImg;
    private Byte shopState;
    private String createTime;
    private String updateTime;
}
