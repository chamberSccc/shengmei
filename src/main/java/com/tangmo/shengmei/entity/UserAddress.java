package com.tangmo.shengmei.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @author boge
 * @date 17/12/25
 * @description 用户地址PO
 */
@Data
public class UserAddress {
    private Integer uaId;
    private String address;
    private String recipient;
    private String mobile;
    private Integer userId;
    private Date createTime;
    private Date updateTime;
}
