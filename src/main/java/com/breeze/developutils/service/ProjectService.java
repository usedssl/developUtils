package com.breeze.developutils.service;

import org.springframework.core.io.FileSystemResource;

public interface ProjectService {
    FileSystemResource fileDownload(String directoryPath, String zipFileName);

    Boolean parseProject(String dirPath);
}
