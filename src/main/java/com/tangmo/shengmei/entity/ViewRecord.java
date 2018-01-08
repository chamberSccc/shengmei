package com.tangmo.shengmei.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author boge
 * @date 18/1/9
 * @description 浏览记录
 */

public class ViewRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer vr_id;
    private Integer userId;
    private Integer goods_id;
    private Integer belong_type;
    private Date createtime;
}
