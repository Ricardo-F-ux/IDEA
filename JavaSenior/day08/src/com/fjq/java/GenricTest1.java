package com.fjq.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 如何自定义泛型结构：泛型类、泛型接口；泛型方法
 *
 * 1.关于自定义泛型类，泛型接口
 *
 *
 * @author EnvyFL
 * @create 2021-04-20-2:24 下午
 * @class
 */
public class GenricTest1 {

    @Test
    public void test1(){
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果大家定义了类是带泛型的，建议实例化要指明类的泛型
        Order order = new Order();
        order.setOrderId(123);
        order.setOrderT("ABC");

        //建议：实例化时指明类的泛型
        Order<String> order1 = new Order<String>("OrderAA",1001,"Order:AA");

        order1.setOrderT("AA:hello");
    }

    @Test
    public void test2(){
        SubOrder sub1 = new SubOrder();
        //由于子类在继承带泛型父类时，指明了泛型类型，则实例化子类对象时，不需要指明泛型
        sub1.setOrderT(1122);

        SubOrder1 <String>sub2 = new SubOrder1<>();
        sub2.setOrderT("AA");
    }

    @Test
    public void test3(){

        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;
        //泛性不同的引用不能相互赋值
//        list1 = list2;


    }

    //测试泛型方法
    @Test
    public void test4(){
        Order<String> order = new Order<>();
        Integer [] arr= new Integer[] {1,2,3,4};
        //泛型方法在调用时，指明了泛型参数的类型。
        List <Integer> list =order.copyFromArrayToList(arr);

        System.out.println(list);
    }

}
