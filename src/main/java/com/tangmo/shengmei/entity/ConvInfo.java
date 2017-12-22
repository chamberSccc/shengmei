package com.tangmo.shengmei.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author boge
 * @date 17/12/22
 * @description
 */

@Data
public class ConvInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer ciId;
    private Integer userId;
    private String title;
    private String subtitle;
    private String content;
    private Date createTime;
    private Date updateTime;
}
