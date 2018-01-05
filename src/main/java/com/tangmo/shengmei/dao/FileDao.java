package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.RsFile;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author boge
 * @date 17/12/22
 * @description 文件信息Dao接口
 */
@Mapper
public interface FileDao {

    /**
     * 增加文件信息
     *
     * @param file
     * @return
     */
    int insertFile(RsFile file);

    /**
     * 查询文件路径信息
     *
     * @param fileId
     * @return
     */
    RsFile selectById(String fileId);
}
