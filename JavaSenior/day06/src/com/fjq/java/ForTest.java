package com.fjq.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk 5.0新增了foreach循环，用于遍历集合、数组
 *
 * @author EnvyFL
 * @create 2021-04-13-8:30 上午
 * @class
 */
public class ForTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Person("Jerry", 20));
        coll.add(false);

        //for( 集合/数组中元素的类型 局部变量 : 集合对象/数组对象){}
        //内部仍然调用了迭代器
        for (Object object:coll) {
            System.out.println(object);
        }
    }

    //遍历数组
    @Test
    public void test2(){
        int arr [] = new int[]{3,4,5};

        for (int i: arr) {
            System.out.println(i);
        }
    }

    //练习题
    @Test
        public void test3(){
        String [] arr = new String[] {"MM","MM","MM"};

        //方式一：
//        for (int i = 0; i < arr.length;i++){
//            arr[i] ="GG";
//        }

        //方式二：增强for循环
        for ( String str: arr) {
            str = "GG";
        }

        for (int i = 0; i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
