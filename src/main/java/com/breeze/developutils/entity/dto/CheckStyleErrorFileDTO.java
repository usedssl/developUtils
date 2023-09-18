package com.breeze.developutils.entity.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @author zhanz
 * @since 2023-09-06
 */
@Data
public class CheckStyleErrorFileDTO implements Serializable {

    /**
     * 文件路径
     */
    private MultipartFile file;

    /**
     * 导出文件类型
     */
    private String exportFileSuffix;

    /**
     * checkStyle读取后缀
     */
    private String readSuffix;
}
