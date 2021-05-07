package com.fjq.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 *
 * 1.缓冲流
 * BufferedInputStream
 * BufferedInputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2.作用：提高流的读取、写入的速度
 *     提高读写速度的原因：内部提供了一个缓冲区
 *
 * 3.处理流，就是"套接"在已有的流的基础上
 *
 *
 * @author EnvyFL
 * @create 2021-04-21-9:41 下午
 * @class
 */
public class BufferTest {

    /*
    实现非文本文件的复制
     */
    @Test
    public void BufferStreamTest()  {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1.造文件
            File srcFile = new File("a.avi");
            File destFile = new File("a1.avi");
            //2.造流
            //2.1造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(srcFile);
            //2.2造处理流（缓冲流）
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取、写入
            byte [] buffer = new byte[5];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);

//                bos.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，在关闭内层的流
            if (bis != null)
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bos != null)
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            //说明：关闭外层流的同时，内层流也会自动进行关闭，关于内层流的关闭，我们可以省略
//            fis.close();
//            fos.close();
        }
    }

    //实现文件复制的方法
    public void copyFileWithBuffered(String srcPath,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //2.造流
            //2.1造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(srcFile);
            //2.2造处理流（缓冲流）
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取、写入
            byte [] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，在关闭内层的流
            if (bis != null)
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bos != null)
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            //说明：关闭外层流的同时，内层流也会自动进行关闭，关于内层流的关闭，我们可以省略
//            fis.close();
//            fos.close();
        }

    }

    @Test
    public void testCopyFileWithBuffered(){
        long start = System.currentTimeMillis();

        String srcPath = "01.avi";
        String destPath = "02.avi";
        copyFileWithBuffered(srcPath,destPath);

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为"+(end - start));//618 --> 176ms
    }


    /*
    使用testBufferedReader和BufferedWriter实现文本文件的复制

     */
    @Test
    public void testBufferedReaderBufferedWriter() {
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            //创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

            //读写操作
            //方式一
//            char [] cbuf = new char[1024];
//            int len ;
//            while ((len = br.read(cbuf)) != -1){
//                bw.write(cbuf,0,len);
//    //            bw.flush();
//            }
            //方式二：使用String
            String data;
            while ((data = br.readLine()) != null){
                //方式一
//             bw.write(data + "\n");
                //方式二
                bw.write(data);//不包含换行符
                bw.newLine();//换行操作
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (br !=null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bw != null)
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }
}
