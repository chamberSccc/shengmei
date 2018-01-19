package com.tangmo.shengmei.entity;

import lombok.Data;


/**
 * @author boge
 * @date 18/1/19
 * @description
 */
@Data
public class LicenseScore {
    private Integer lsId;
    private String fileId;
    private String licenseId;
    private String Score;
    private String validDate;
}
