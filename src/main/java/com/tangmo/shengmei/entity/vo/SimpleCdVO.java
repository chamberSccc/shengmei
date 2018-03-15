package com.tangmo.shengmei.entity.vo;

import lombok.Data;

import java.sql.Date;

/**
 * @author boge
 * @date 18/3/15
 * @description
 */
@Data
public class SimpleCdVO {

    private static final long serialVersionUID = 1L;
    private Integer cdId;
    private String imgId;
    private String[] imgList;
    private String title;
    private Byte cdType;
    private String condition;
    private Double priceNow;
    private String city;
    private String district;
    private String content;
    private Date createtime;

    public void setImgId(String imgId) {
        if(imgId == null){
            this.imgList = new String[]{};
        }
        String[] list = imgId.split(",");
        this.imgId = list[0];
    }

}
