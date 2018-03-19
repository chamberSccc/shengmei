package com.tangmo.shengmei.entity;

import com.tangmo.shengmei.entity.vo.ShopCartCdVO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author boge
 * @date 17/12/27
 * @description 用户购物车PO
 */
@Data
public class ShopCart implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer scId;
    private Integer userId;
    private Integer cdId;
    private Double price;
    private Integer payCount;
    private String scColor;
    private String scSize;
    private ShopCartCdVO commodity;


    public ShopCartCdVO getCommodity() {
        if(commodity == null){
            return new ShopCartCdVO();
        }
        return commodity;
    }
}
