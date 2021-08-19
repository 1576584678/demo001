package com.example.demo001.test;

import com.example.demo001.utils.FileUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilTest {

    @Test
    void copyFile() {
        String infile = "F:\\GameDownload\\LOL_V4.2.5.3_FULL.7z.001";
        String outfile = "D:\\LOL.7z.001";
        boolean flag= FileUtil.copyFile(infile,outfile);
        System.out.print("文件复制"+(flag?"成功":"失败")+"!");
    }
}