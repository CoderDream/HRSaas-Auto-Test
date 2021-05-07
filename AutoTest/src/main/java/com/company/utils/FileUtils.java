package com.company.utils;

import java.io.File;

public class FileUtils {

    /**
     * 判断文件是否存在
     * @param filePath
     * @return
     */
    public static boolean isFileExist(String filePath){
        File file = new File(filePath);
        return file.exists();
    }
}
