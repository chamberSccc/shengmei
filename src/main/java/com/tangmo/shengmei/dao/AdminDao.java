package com.tangmo.shengmei.dao;



import com.tangmo.shengmei.entity.ReportDto;
import org.apache.ibatis.annotations.Mapper;

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

    List<Map<String,Objects>> selectUserReport(ReportDto reportDto);
}
