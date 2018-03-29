package com.tangmo.shengmei.entity;

import lombok.Data;

/**
 * @author boge
 * @date 18/3/29
 * @description
 */
@Data
public class IllegalOrder {
    private Integer userId;
    private Integer totalFee;
    private String[] illegalIds;
}
