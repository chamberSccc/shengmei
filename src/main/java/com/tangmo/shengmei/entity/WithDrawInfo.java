package com.tangmo.shengmei.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author boge
 * @date 18/1/9
 * @description 提现记录PO
 */
@Data
public class WithDrawInfo implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer wiId;
    private Integer userId;
    private Double amount;
    private String orderNum;
    private String wiWay;
    private Date createTime;
}
