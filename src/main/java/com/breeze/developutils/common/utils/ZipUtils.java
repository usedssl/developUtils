package com.breeze.developutils.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils {

    public static void zipFiles(File directory, File base, ZipOutputStream zipOutputStream) throws IOException {
        File[] files = directory.listFiles();
        byte[] buffer = new byte[1024];

        for (File file : files) {
            if (file.isDirectory()) {
                zipFiles(file, base, zipOutputStream);
            } else {
                FileInputStream fileInputStream = new FileInputStream(file);
                String entryPath = file.getAbsolutePath().substring(base.getAbsolutePath().length() + 1);
                ZipEntry zipEntry = new ZipEntry(entryPath);
                zipOutputStream.putNextEntry(zipEntry);

                int length;
                while ((length = fileInputStream.read(buffer)) >= 0) {
                    zipOutputStream.write(buffer, 0, length);
                }

                fileInputStream.close();
            }
        }
    }
}
