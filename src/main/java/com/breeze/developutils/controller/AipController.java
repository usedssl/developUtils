package com.breeze.developutils.controller;


import com.breeze.developutils.common.utils.ZipUtils;
import com.breeze.developutils.service.ProjectService;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 */
@RestController
@Log4j2
@RequestMapping("/api")
public class AipController {

    public static void main(String[] args) {
        /*String a = "0-";
        String[] split = a.split("-");

        String resourcePath = AipController.class.getClassLoader().getResource("").getPath();
        System.out.println("Resource 文件夹的路径：" + resourcePath);
        String compiledPath = AipController.class.getResource("").getPath();
        System.out.println("编译后的资源路径：" + compiledPath);
        String projectPath = System.getProperty("user.dir");
        System.out.println("当前项目的绝对路径：" + projectPath);*/
    }

    @Resource
    private ProjectService projectService;

    @GetMapping("/download")
    public ResponseEntity<FileSystemResource> downloadFile(){
        // 文件目录路径
        String directoryPath = "/path/to/files";
        // 压缩包文件名
        String zipFileName = "files.zip";
        FileSystemResource resource = projectService.fileDownload(directoryPath, zipFileName);
        return ResponseEntity.ok()
                //.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + zipFile.getName())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                //.contentLength(zipFile.length())
                .body(resource);
    }

    @GetMapping("/parseProject")
    public ResponseEntity<Boolean>  parseProject(@RequestParam String dirPath){
        return ResponseEntity.ok().body( projectService.parseProject(dirPath));
    }

}
