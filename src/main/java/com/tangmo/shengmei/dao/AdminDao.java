package com.tangmo.shengmei.dao;


import com.tangmo.shengmei.entity.AdminInfo;
import com.tangmo.shengmei.entity.ReportDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author boge
 * @date 18/1/11
 * @description 管理员Dao
 */
@Mapper
public interface AdminDao {

    /**
     * 用户消费报表
     *
     * @param reportDto
     * @return
     */
    List<Map<String, Objects>> selectUserReport(ReportDto reportDto);

    /**
     * 增加管理员
     *
     * @param adminInfo
     * @return
     */
    int insertAdmin(AdminInfo adminInfo);

    /**
     * 通过账户查询管理员信息
     *
     * @param account
     * @return
     */
    AdminInfo selectByAccount(String account);

    /**
     * 查询用户token信息
     *
     * @param userId
     * @return
     */
    String selectTokenById(@Param("userId") Integer userId);


}
