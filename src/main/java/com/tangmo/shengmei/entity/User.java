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
    private String mobile;
    private String username;
    private String avatarId;
    private Date createTime;
    private Date updateTime;
}
