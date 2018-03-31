package com.tangmo.shengmei.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @author boge
 * @date 18/3/30
 * @description 违章代缴实体
 */
@Data
public class IllegalHandle {

    private Integer userId;
    private String carNo;
    private Integer illegalMount;
    private Integer payFee;
    //自己的订单号
    private String outOrderNo;
    //极速订单号
    private String orderNo;
    private String score;
    private Integer handleMount;
    private Integer handleFee;
    private String  state;
    private String mobile;
    private String illegalId;
    private Date createTime;
    private Integer serviceFee;

    public IllegalHandle() {
    }
}
