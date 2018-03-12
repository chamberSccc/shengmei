package com.tangmo.shengmei.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author boge
 * @date 18/3/12
 * @description
 */
@Data
public class UserVO implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer userId;
    private String mobile;
    private String username;
    private String province;
    private String city;
    private Byte gender;
    private String avatarId;
    private Byte isMerchant;
}
