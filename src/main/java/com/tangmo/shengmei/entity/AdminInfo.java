package com.tangmo.shengmei.entity;

import lombok.Data;

/**
 * @author boge
 * @date 18/1/15
 * @description 管理员对象
 */
@Data
public class AdminInfo {
    private Integer adminId;
    private String account;
    private String password;
}
