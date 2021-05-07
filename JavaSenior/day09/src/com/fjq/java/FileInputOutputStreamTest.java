package com.fjq.java;

import org.junit.Test;

import java.io.*;

/**
 * 测试FileInputStream和FileOutputStream的使用
 *
 *  结论：
 *  1.对于文本文件(txt,java,c,cpp)，使用字符流处理
 *  2.对于非文本文件(jpg,mp4,mp3,avi,doc,ppt...)，使用字节流处理
 *
 *
 *
 * @author EnvyFL
 * @create 2021-04-21-9:14 下午
 * @class
 */
public class FileInputOutputStreamTest  {

    //使用自己流FileInputStreamTest处理文本文件，可能出现乱码的
    @Test
    public void test1()  {
        FileInputStream fis = null;
        try {
            //1.造文件
            File file =new File("hello.txt");

            //2.造流
            fis = new FileInputStream(file);

            //3.读数据
            byte [] buffer = new byte[5];
            int len;//记录每次读取的字节个数
            while ((len = fis.read(buffer))!= -1){
                String str = new String(buffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.关闭资源
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //实现对图片的复制操作
    @Test
    public void test2(){
        //
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("a.jpg");
            File destFile = new File("a1.jpg");

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(srcFile);

            //复制的过程
            byte [] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //
            if (fos!=null)
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }


    //指定路径下文件的复制
    public void copyFile(String srcPath,String destPath){
        //
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制的过程
            byte [] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //
            if (fos!=null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();

        String srcPath = "01.avi";
        String destPath = "02.avi";
        copyFile(srcPath,destPath);

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为"+(end - start));//618ms
    }
}
