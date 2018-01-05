package com.tangmo.shengmei.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author boge
 * @date 18/1/5
 * @description 便民信息评论对象
 */
@Data
public class ConvComment implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer ccId;
    private Integer ciId;
    private Integer userId;
    private String userName;
    private String userAvatar;
    private String comment;
}
