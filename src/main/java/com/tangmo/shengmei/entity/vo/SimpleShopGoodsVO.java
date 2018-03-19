package com.tangmo.shengmei.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author boge
 * @date 18/3/13
 * @description 店铺服务列表简要信息vo
 */
@Data
public class SimpleShopGoodsVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer sgId;
    private String shopName;
    private String shopContent;
    private String imgId;
    private Double price;
    private String city;
    private String district;

    public void setImgId(String imgId) {
        if(imgId != null){
            String[] list = imgId.split(",");
            this.imgId = list[0];
        }else{
            this.imgId = imgId;
        }

    }
}
