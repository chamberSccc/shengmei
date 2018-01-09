package com.tangmo.shengmei.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author boge
 * @date 18/1/9
 * @description 反馈信息
 */
@Data
public class FeedBack implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer fbId;
    private Integer userId;
    private String content;
    private String mobile;
    private String imgId;
}
