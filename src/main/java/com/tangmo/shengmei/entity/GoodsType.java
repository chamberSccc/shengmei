package com.tangmo.shengmei.entity;

import lombok.Data;

/**
 * @author boge
 * @date 18/1/15
 * @description 商品分类 全新汽配/二手汽配
 */
@Data
public class GoodsType {

    private Integer id;
    private String name;
    private Byte value;
}
