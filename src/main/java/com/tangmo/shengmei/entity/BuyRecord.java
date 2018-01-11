package com.tangmo.shengmei.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author boge
 * @date 18/1/11
 * @description 购买记录实体
 */
@Data
public class BuyRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer brId;
    private Integer userId;
    private Integer amount;
    private Byte isShow;
    private Date createTime;

    /**
     * 商品简要信息
     */
    private Integer goodsId;
    private String imgId;
    private String title;
    private String content;
    private Double price;
    private Integer brCount;
    private String brColor;
    private String brSize;

}
