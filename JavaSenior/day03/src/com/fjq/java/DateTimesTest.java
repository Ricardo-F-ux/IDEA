package com.fjq.java;

import org.junit.Test;

import java.util.Date;

/**
 * JDK8之前日期和时间的API测试
 *
 * @author EnvyFL
 * @create 2021-04-07-9:25 下午
 * @class
 */
public class DateTimesTest {

    /*
    java.util.Date类
           ｜---- java.sql.Date类
    1.两个构造器的使用
           >构造器一：Date() 创建了一个对应当前时间的Date对象
           >构造器二：创建指定毫秒数的Date对象

    2.两个方法的使用
           >toString()：显示当前的年，月，日，时，分，秒
           >getTime()： 获取当前Date对象对应的毫秒数（时间戳）

    3.java.sql.Date对应着数据库中的日期类型变量
        >如何实例化
        >sql.Date ---> util.Date对象 多态
        >如何将java.util.Date对象转换为java.sql.Date对象

     */

    @Test
    public void test2(){
        //构造器一：Date() 创建了一个对应当前时间的Date对象
        Date date1 =new Date();
        System.out.println(date1.toString());//Wed Apr 07 21:30:40 CST 2021

        System.out.println(date1.getTime());//1617802308275


        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1617802308275L);
        System.out.println(date2);

        //创建了java.sql.Date对象
        Date date3 = new java.sql.Date(617802308275L);
        System.out.println(date3.toString()); //1989-07-30

        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况一：
//        Date date4 = new java.sql.Date(627802308275L);
//        java.sql.Date date5 = (java.sql.Date) date4;
        //情况二：
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
    }

    //1.System类中的currentTimeMillis()
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差-->称为时间戳
        System.out.println(time);
    }
}
