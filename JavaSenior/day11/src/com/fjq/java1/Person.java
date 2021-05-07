package com.fjq.java1;

import java.util.Comparator;

/**
 * @author EnvyFL
 * @create 2021-04-23-11:26 下午
 * @class
 */
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String> ,MyInterface{

    private String name;
    int age;
    public int id;

    @MyAnnotation(value = "abc")
    public Person(String name){
        this.name = name;

    }

    Person(String name,int age){
        this.name = name;
        this.age =age;
    }

    @MyAnnotation
    private String show(String nation){
        System.out.println("我的国籍是"+ nation);
        return nation;
    }

    public String display(String interests){
        return  interests;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    public static void showDesc(){

        System.out.println("我是一个可爱的人");
    }
}
