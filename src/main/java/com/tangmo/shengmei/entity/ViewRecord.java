package com.tangmo.shengmei.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author boge
 * @date 18/1/9
 * @description 浏览记录
 */
@Data
public class ViewRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer vrId;
    private Integer userId;
    private Integer goodsId;
    private Byte belongType;
    private Byte cdType;
    private String imgId;
    private String title;
    private String content;
    private Date createTime;

    public ViewRecord() {
    }

    public ViewRecord(Integer userId, Integer goodsId, Byte belongType) {
        this.userId = userId;
        this.goodsId = goodsId;
        this.belongType = belongType;
    }
}
