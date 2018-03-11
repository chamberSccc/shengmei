package com.tangmo.shengmei.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @author boge
 * @date 18/3/10
 * @description
 */
@Data
public class ExpressVO {
    private String company;
    private String number;
    private Integer deliverystatus;
    private String msg;
    private List<ExpressDetailVO> expressDetailVOs;
}
