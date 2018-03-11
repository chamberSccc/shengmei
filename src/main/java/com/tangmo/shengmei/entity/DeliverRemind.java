package com.tangmo.shengmei.entity;

import lombok.Data;

/**
 * @author boge
 * @date 18/3/10
 * @description
 */
@Data
public class DeliverRemind {
    private Integer drId;
    private Integer goId;
    private Integer userId;
    private Integer merchantId;
    private Byte isRead;
}
