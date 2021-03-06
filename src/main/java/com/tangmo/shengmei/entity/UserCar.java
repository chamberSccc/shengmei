package com.tangmo.shengmei.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author boge
 * @date 17/12/26
 * @description 用户车辆实体类PO
 */
@Data
public class UserCar implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer ucId;
    private Integer userId;
    private String carNum;
    private String carProvince;
    private String frameNum;
    private Byte carType;
    private String engineNum;
    private Byte isSave;
    private Date createTime;
    private Date updateTime;

}
