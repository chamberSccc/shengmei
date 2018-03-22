package com.tangmo.shengmei.entity.vo;

import lombok.Data;

import java.sql.Date;

/**
 * @author boge
 * @date 18/3/22
 * @description 车友圈/视频列表vo
 */
@Data
public class ForumListVO {
    private Integer cfId;
    private Integer userId;
    private String userName;
    private String avatarId;
    private Integer viewCount;
    private Integer starCount;
    private Integer commentCount;
    private String content;
    private String mediaId;
    private String[] imgList;
    private Byte cfType;
    private Date createTime;

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
