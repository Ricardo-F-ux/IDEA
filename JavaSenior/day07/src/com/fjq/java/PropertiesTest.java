package com.fjq.java;

import java.util.Properties;

/**
 * @author EnvyFL
 * @create 2021-04-20-10:20 上午
 * @class
 */
public class PropertiesTest {

    //Properties:常用来处理配置文件。key和value都是String类型

    public static void main(String[] args) throws Exception{
        Properties pros = new Properties();
//        FileInputStream fis = new FileInputStream(jdbc.properties);
//        pros.load(fis); //加载流对应的文件

        String name = pros.getProperty("Name");
        String password = pros.getProperty("password");
        System.out.println(name+password);



    }
}
