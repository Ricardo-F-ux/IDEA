package com.fjq.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及到String类与其他结构之间的转换
 *
 *
 * @author EnvyFL
 * @create 2021-04-07-6:44 下午
 * @class
 */
public class StringTest1 {
    /*
    String 与 byte[] 之间的转换
    编码：String --> byte[]:调用String的getBytes()
    解码：byte[] --> String

    编码：字符串 --> 字节（看得懂 --> 看不懂）
    解码：编码的逆过程 字节 --> 字符串（看不懂 --> 看得懂）

    说明：解码时，要求解码使用的字符集必须与编码使用的字符集一致，否则会出现乱码
    */

    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//使用默认的字符集，来编码
        System.out.println(Arrays.toString(bytes));

        byte[] bytes1 = str1.getBytes("gbk");//使用gbk字符集进行编码
        System.out.println(Arrays.toString(bytes1));

        System.out.println("**************************");

        String str2 = new String(bytes);//使用默认的字符集，来解码
        System.out.println(str2);

        String str3 = new String(bytes1);
        System.out.println(str3);//出现乱码 原因 编码集和解码集不一致！！

        String str4 =new String(bytes1,"gbk");
        System.out.println(str4);//没有出现乱码 原因 编码集和解码集一致！！
    }

    /*
    String 与 char[] 之间的转换

    String --> char[]:调用String的toCharArray(
    char[] --> String:调用String的构造器

     */

    @Test
    public void test2(){
        String str1 = "abc123";
        char arr[] = str1.toCharArray();
        for (int i = 0;i <arr.length;i++){
            System.out.println(arr[i]);
        }

        char[] arr1 = {'a','c','d','e'};
        String str2 = new String(arr1);
        System.out.println(str2);
    }


    /*
    复习：
    String 与 基本数据类型、包装类之间的转换

    String --> 基本数据类型、包装类：调用包装类的静态方法parseXxx(str)

    基本数据类型、包装类 --> String：调用String重载的valueof(xxx)
     */

    @Test
    public void test1(){
        String str1 = "123";
//        int num = (int) str1;错误的
        int num = Integer.parseInt(str1);

        String  str2 = String.valueOf(num);
        String str3 = num + "";
    }
}
