package com.breeze.developutils.service.impl;

import com.breeze.developutils.common.utils.ZipUtils;
import com.breeze.developutils.service.ProjectService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipOutputStream;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Override
    public FileSystemResource fileDownload(String directoryPath, String zipFileName) {
        File directory = new File(directoryPath);
        File zipFile = new File(directoryPath, zipFileName);
        try {
            try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile))) {
                ZipUtils.zipFiles(directory, directory, zipOutputStream);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return new FileSystemResource(zipFile);
    }

    @Override
    public Boolean parseProject(String dirPath) {
        //解析项目 做成读取解析类默认解析类为java 后续扩展py、c、c++等工程
        //
        return null;
    }
}
