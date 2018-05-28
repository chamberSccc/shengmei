package com.tangmo.shengmei.entity.vo;

import lombok.Data;

import java.sql.Date;

/**
 * @author boge
 * @date 18/3/17
 * @description
 */
@Data
public class ShopServiceVO {
    private static final long serialVersionUID = 1L;
    private Integer sgId;
    private Integer userId;
    private String username;
    private String avatarId;
    private String city;
    private String shopName;
    private String shopContent;
    private String imgId;
    private Byte serviceType;
    private Double price;
    private String discountNote;
    private String mobile;
    private String address;
    private Date createtime;

    private String[] imgList;
    private String imgIds;

    public void setImgId(String imgId) {
        if(imgId == null){
            this.imgList = new String[]{};
        }else {
            String[] list = imgId.split(",");
            this.imgIds = imgId;
            this.imgId = list[0];
            this.imgList = list;
        }
    }
}
