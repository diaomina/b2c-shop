package com.soft.common.util;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @Description 处理文件上传的工具类
 * @Author ljy
 * @Date 2020/1/27 13:45
 **/
public class FileUtil {

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {

        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + "/" +fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}