package com.example.demo001.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author l1500
 *
 */
@Slf4j
public class FileUtil {

    /**
     * 文件复制
     * @param orgFile
     * @param tagFile
     * @return 成功或失败
     */
    public static boolean copyFile(String orgFile,String tagFile){
        try (
                // 创建原文件输入流
                FileInputStream inputStream = new FileInputStream(orgFile);
                // 创建目标文件输出流
                FileOutputStream outputStream=new FileOutputStream(tagFile);
                // 获取原文件输入通道
                FileChannel fcin = inputStream.getChannel();
                // 获取目标文件输出通道
                FileChannel fcout = outputStream.getChannel();
        ) {
            // 创建缓冲区对象
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int r = 0;
            while (r>-1){
                // 从输入通道读取数据到缓冲区
                r=fcin.read(buffer);
                // 切换读写模式
                buffer.flip();
                // 将缓冲区数据写入输出通道
                fcout.write(buffer);
                // 清空缓冲区
                buffer.clear();
            }
            return true;
        }catch (IOException e){
            log.error(e.getLocalizedMessage());
            return false;
        }
    }
    public static void main(String[] args)   {
        String infile = "E:\\密钥\\备忘.txt";
        String outfile = "D:\\备忘1.txt";
        boolean flag=copyFile(infile,outfile);
        System.out.print("文件复制"+(flag?"成功":"失败")+"!");
    }
}
