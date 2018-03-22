package com.tangmo.shengmei.entity;

import lombok.Data;

/**
 * @author boge
 * @date 18/3/21
 * @description 车友圈评论
 */
@Data
public class ForumComment {
    private Integer fcId;
    private Integer userId;
    private Integer cfId;
    private String content;
}
