package com.fjq.java;

import org.junit.Test;

import java.util.*;

/**
 *
 * 泛型的使用
 * 1.jdk 5.0新增的特性
 *
 * 2.在集合中使用泛型
 *  总结：
 *      1.集合接口或集合类在jdk5.0时都修改为带泛型的接口
 *      2.在实例化集合类时，可以指明具体泛型类型
 *      3.指明完以后，在集合类或接口中凡是定义类或接口时，内部接口（比如：方法、构造器、属性等）使用到类的泛型的位置，都指定
 *        为实例化的泛型类型。  比如: add(E e) --> 实例化以后：add(Integer e)
 *      4.注意点：泛型的类型必须是类，不能是基本数据类型，需要用到基本数据类型时，用包装类代替
 *      5.如果实例化时,没有指明泛型的类型，默认类型为java.util.Object
 *
 * 3.如何自定义泛型结构：泛型类、泛型接口；泛型方法
 *
 *
 *
 *
 * @author EnvyFL
 * @create 2021-04-20-12:19 下午
 * @class
 */
public class GenericTest {

    //在集合中使用泛型之前的情况
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        //需求：存放学生成绩
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //问题一：类型不安全
//        list.add("Tom");

        for (Object score : list) {
            //问题二：强转时，可能出现ClassCastException
            int stuScore = (Integer) score;

            System.out.println(stuScore);
        }

    }

    //在集合中使用泛型之前的情况
    @Test
    public void test2(){
        //ArrayList<Integer>  list = new ArrayList<Integer>();
        //jdk7.0 类型推断
        ArrayList<Integer>  list = new ArrayList<>();
        list.add(78);
        list.add(87);
        list.add(99);
        list.add(65);
        //编译时，就会进行类型转换，保证数据安全
//        list.add("Tom");
        //方式一：
//        for (Integer score:list) {
//            //避免了强转操作
//            int stuScore = score;
//            System.out.println(stuScore);
//        }

        //方式二：
       Iterator<Integer> iterator = list.iterator();
       while (iterator.hasNext()){
           System.out.println(iterator.next());
       }

    }

    ////在集合中使用泛型之前的情况:以HashMap为例
    @Test
    public void test3(){
        Map<String,Integer> map = new HashMap<String, Integer>();

        map.put("Tom",87);
        map.put("Jerry",87);
        map.put("Jack",67);

//        map.put(123,"ABC");
        //泛型的嵌套
        Set<Map.Entry<String,Integer>> enty = map.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator = enty.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();

            System.out.println(key+"----"+value);

        }

    }


}
