package com.tangmo.shengmei.entity.vo;

import lombok.Data;

/**
 * @author boge
 * @date 18/3/13
 * @description 商家商品信息管理页面展示
 */
@Data
public class CdManageVO {
    private Integer cdId;
    private String imgId;
    private String title;
    private Double priceNow;
    private Integer sellCount;
    private Integer cdCount;
}
