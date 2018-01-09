package com.tangmo.shengmei.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author boge
 * @date 17/12/25
 * @description 用户地址PO
 */
@Data
public class UserAddress implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer uaId;
    private String address;
    private String recipient;
    private String mobile;
    private Integer userId;
    private Byte isDefault;
    private Date createTime;
    private Date updateTime;
}
