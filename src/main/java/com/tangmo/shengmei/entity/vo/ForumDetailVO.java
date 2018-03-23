package com.tangmo.shengmei.entity.vo;

import lombok.Data;

import java.sql.Date;

/**
 * @author boge
 * @date 18/3/22
 * @description 车友圈详情VO
 */
@Data
public class ForumDetailVO {
    private Integer cfId;
    private Integer userId;
    private String content;
    private String userName;
    private String avatarId;
    private String mediaId;
    private Integer viewCount;
    private Integer starCount;
    private Integer commentCount;
    private Date createTime;
    private String[] imgList;

    public void setMediaId(String mediaId) {
        if(mediaId == null){
            this.imgList = new String[]{};
        }else{
            String[] list = mediaId.split(",");
            this.mediaId = list[0];
            this.imgList = list;
        }
        this.mediaId = mediaId;
    }
}
