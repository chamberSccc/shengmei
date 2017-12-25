package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.FileDao;
import com.tangmo.shengmei.entity.File;
import com.tangmo.shengmei.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author boge
 * @date 17/12/22
 * @description
 */
@Service("fileService")
public class FileServiceImpl implements FileService {

    @Resource
    private FileDao fileDao;

    @Override
    @Transactional
    public File addFile(File file) {
        fileDao.insertFile(file);
        return file;
    }

    @Override
    public String getFilePath(String fileId) {
        return null;
    }
}
