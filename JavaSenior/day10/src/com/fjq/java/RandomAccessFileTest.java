package com.fjq.java;

import org.junit.Test;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


/**
 * RandomAccessFile的使用
 * 1.RandomAccessFile直接继承于java.lang.io类，实现了DataInput、DataOutput接口
 * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 *
 * 3.如果RandomAccessFile作为输出流时，写到的文件如果不存在，则在执行过程中自动创建
 *   如果写出到的文件存在，则会对原有文件进行覆盖。（默认情况下，从头覆盖）
 *
 * 4.可以通过相关操作，实现RandomAccessFile"插入"数据的效果
 *
 *
 *
 * @author EnvyFL
 * @create 2021-04-22-10:32 下午
 * @class
 */
public class RandomAccessFileTest {


    @Test
    public void test1()   {

        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("a.jpg"),"r");
            raf2 = new RandomAccessFile(new File("b.jpg"),"rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1){
                    raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf1 != null)
                raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (raf2 != null)
                raf2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() throws IOException{

        RandomAccessFile raf1 = new RandomAccessFile(new File("hello.txt"),"rw");

        raf1.seek(3);//将指针调到角标为3的位置
        raf1.write("wyz".getBytes());

        raf1.close();

    }

    /*
    使用RandomAccessFile实现数据插入效果
     */
    @Test
    public void test3() throws IOException{
        RandomAccessFile raf1 = new RandomAccessFile(new File("hello.txt"),"rw");

        raf1.seek(3);//将指针调到角标为3的位置
        //保存指针3后面的所有数据到StringBuilder中
        StringBuilder buider = new StringBuilder((int)new File("hello.txt").length());
        byte [] buffer = new byte[20];
        int len;
        while ((len = raf1.read(buffer)) != -1){
            buider.append(new String(buffer,0,len));
        }
        //调回指针，写入xyz
        raf1.seek(3);
        raf1.write("xyz".getBytes());

        //将StringBuilder
        raf1.write(buider.toString().getBytes());

        raf1.close();

        //思考：将StringBuilder替换为ByteArrayOutputStream
    }

}
