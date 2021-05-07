package com.fjq.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * jdk 8当中的日期时间API测试
 *
 * @author EnvyFL
 * @create 2021-04-09-1:20 下午
 * @class
 */
public class JDK8DateTimeTest {

    @Test
    //偏移量
    public void testDate(){
        Date date = new Date(2020 - 1900,9 -1,8);
        System.out.print(date); //Tue Sep 08 00:00:00 CST 2020
    }

    /*
    LocalDate、LocalTime、LocalDateTime的使用
    说明
        1.LocalDate相较于LocalTime、LocalDateTime的使用频率较高
        2.类似于Calendar
     */
    @Test
    public void test1(){

        //now() 获取当前时间或者日期 当前时间和日期
        LocalDate localDate =LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime =LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of() 设置指定的年月日时分秒 没有偏移量的
        LocalDateTime l1 = LocalDateTime.of(2020,10,6,13,23,43);
        System.out.println(l1);

        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());

        //withXxx() 设置相关属性
        // 体现了不可变性
        LocalDate localDate1 =  localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);

//        LocalDateTime localDateTime1 = localDateTime.withHour(4);

        LocalDateTime localDateTime1 =localDateTime.plusMonths(3);
        System.out.println(localDateTime1);

        LocalDateTime localDateTime2 =localDateTime.minusMonths(2);

        System.out.println(System.currentTimeMillis());

    }
    /*

    Instant的使用瞬时点

     */
    @Test
    public  void test2(){
        //now() 获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);//2021-04-09T05:46:45.914408Z


        //添加时间偏移量
        OffsetDateTime offsetDateTime =instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //toEpochMilli():获取对应的毫秒数 返回1970-01-01 00:00:00到当前时间的毫秒数，即为时间戳 --> Date类的getTime()
        long l =  instant.toEpochMilli();
        System.out.println(l);

        //ofEpochMilli(long epochMilli) 通过给定的毫秒数，获取Instant实例 --> Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1617947489991L);
        System.out.println(instant1 );
    }

    /*
    DateTimeFormatter格式化与解析日期或时间
    类似于SimpleDateFormat

     */

    @Test
    public void test3(){
//      方式一  预定义的标准格式。如： ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter dateTimeFormatter =DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = dateTimeFormatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);//2021-04-09T14:52:46.179594

        //解析：字符串 --> 日期
        TemporalAccessor temporalAccessor =dateTimeFormatter.parse("2021-04-09 14:52:46");
        System.out.println(temporalAccessor);


//      方式二  本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)
        DateTimeFormatter dateTimeFormatter1 =DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        String str2 = dateTimeFormatter1.format(localDateTime);
        System.out.println(str2);


//       方式三  自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        //格式化
        DateTimeFormatter dateTimeFormatter2 =DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String  str3 = dateTimeFormatter2.format(localDateTime);
        System.out.println(str3);

        //解析
        TemporalAccessor temporalAccessor1 =dateTimeFormatter2.parse("2021-04-09 14:52:46");
        System.out.println(temporalAccessor1);
    }
}
