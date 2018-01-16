package com.tangmo.shengmei.entity;

import lombok.Data;

/**
 * @author boge
 * @date 18/1/15
 * @description  商品分类
 */
@Data
public class GoodsTypeItem {

    private Integer id;
    private Byte gtId;
    private String name;
    private Byte value;
}
