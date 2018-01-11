package com.tangmo.shengmei.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @author boge
 * @date 18/1/11
 * @description
 */
@Data
public class ReportDto {
    private Integer start;
    private Integer end;
    private Date startDate;
    private Date endDate;
    private String province;
    private String city;
}
