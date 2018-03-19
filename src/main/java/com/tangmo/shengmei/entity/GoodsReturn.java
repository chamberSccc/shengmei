package com.tangmo.shengmei.entity;

import lombok.Data;

/**
 * @author boge
 * @date 18/3/10
 * @description 退款数据
 */
@Data
public class GoodsReturn {

    private Integer grId;
    private Integer userId;
    private Integer goId;
    private Integer merchantId;
    private String reason;
    private String grExplain;

    public String getGrExplain() {
        if(grExplain == null){
            return "";
        }
        return grExplain;
    }

    public void setGrExplain(String grExplain) {
        if(grExplain == null){
            grExplain = "";
        }
        this.grExplain = grExplain;
    }
}
