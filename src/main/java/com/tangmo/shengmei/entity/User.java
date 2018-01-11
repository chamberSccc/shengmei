package com.tangmo.shengmei.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author boge
 * @date 17/12/20
 * @description 用户实体类PO
 */

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer userId;
    private String password;
    private String newPwd;
    private String mobile;
    private String username;
    private String province;
    private String city;
    private Byte gender;
    private String avatarId;
    private Double balance;
    private Byte shopAuth;
    private Date createTime;
    private Date updateTime;
}
