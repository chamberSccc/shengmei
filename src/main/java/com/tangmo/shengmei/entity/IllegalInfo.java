package com.tangmo.shengmei.entity;

import lombok.Data;

import java.sql.Date;
import java.util.List;

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
    private String username;
    private String carProvince;
    private String carNum;
    private Integer totalPrice;
    private Integer totalScore;
    private String msg;
    private List<IllegalDetail> illegalDetails;

    public IllegalInfo() {
    }

    public IllegalInfo(Integer userId, Integer carId, Integer totalPrice, Integer totalScore) {
        this.userId = userId;
        this.carId = carId;
        this.totalPrice = totalPrice;
        this.totalScore = totalScore;
    }
}
