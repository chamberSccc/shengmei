package com.tangmo.shengmei.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @author boge
 * @date 18/1/15
 * @description 访问信息
 */
@Data
public class AccessCount {

    private Integer acId;
    private String ip;
    private String province;
    private String city;
    private Date createTime;
}
