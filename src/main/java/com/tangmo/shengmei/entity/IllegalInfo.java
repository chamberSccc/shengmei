package com.tangmo.shengmei.entity;

import lombok.Data;

/**
 * @author boge
 * @date 18/1/16
 * @description 违章信息
 */
@Data
public class IllegalInfo {

    private Integer id;
    private Integer userId;
    private Integer carId;
    private Integer totalPrice;
    private Integer totalScore;
    private Integer handleFee;
    private Integer canHandle;
    //违章编号
    private String number;
}
