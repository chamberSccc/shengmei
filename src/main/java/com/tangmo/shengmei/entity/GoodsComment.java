package com.tangmo.shengmei.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author boge
 * @date 18/1/9
 * @description 商品评论表
 */
@Data
public class GoodsComment implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer gcId;
    private Integer goodsId;
    private Integer userId;
    private String username;
    private String avatarId;
    private Byte belongType;
    private String comment;

    /**
     * 评价指标相关
     */
    private Byte isAnonymous;
    private Byte star;
    private Date createTime;

    public void setStar(Byte star) {
        if(star == null){
            star = 0;
        }
        this.star = star;
    }

    public void setIsAnonymous(Byte isAnonymous) {
        if(isAnonymous == null){
            isAnonymous = 0;
        }
        this.isAnonymous = isAnonymous;
    }

    public Byte getStar() {
        if(star == null){
            return 0;
        }
        return star;
    }

    public Byte getIsAnonymous() {
        if(isAnonymous == null){
            return 0;
        }
        return isAnonymous;
    }
}
