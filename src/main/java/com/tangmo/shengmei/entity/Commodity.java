package com.tangmo.shengmei.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author boge
 * @date 17/12/25
 * @description 商品信息实体类PO
 */
@Data
public class Commodity implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer cdId;
    private Integer userId;
    private String username;
    private String avatarId;
    private String imgId;
    private String[] imgList;
    private String title;
    private String content;
    private Byte cdType;
    private Integer cdCount;
    private Double pricePre;
    private Double priceNow;
    private String cdColor;
    private String cdSize;
    private Byte isQuality;
    private Byte isSell;
    private String province;
    private String city;
    private String district;
    private Byte cdClass;
    private Integer star;

    public void setImgId(String imgId) {
        if(imgId == null){
            this.imgList = new String[]{};
        }
        String[] list = imgId.split(",");
        this.imgId = imgId;
        this.imgList = list;
    }

    private String condition;
    private Double discountFee;
    private Double expressFee;
    private Date createTime;
    private Date updateTime;
}
