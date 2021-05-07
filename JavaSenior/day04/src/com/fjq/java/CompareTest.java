package com.fjq.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一、说明：Java中的对象，正常情况下 ，只能进行比较 == 或 !=  不能使用 > 或 < 的
 *          但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小
 *          如何实现？使用两个接口中的任何一个 :Comparable 或 Comparator
 *
 * 二、Comparable接口与Comparator的使用对比
 *      Comparable接口的方式一旦指定，保证Comparable接口实现类的对象在任何位置都可以比较大小
 *      Comparator接口属于临时性比较
 *
 *
 *
 * @author EnvyFL
 * @create 2021-04-09-3:25 下午
 * @class
 */
public class CompareTest {
    /*
    Comparable接口的使用举例：自然排序
    1、像String、包装类实现了Comparable接口，重写了compareTo()方法，给出了两个对象大小比较的方法
    2、像String、包装类重写compareTo()方法以后，进行了从小到大排列
    3、重写compareTo()的规则：
        如果当前对象this大 于形参对象obj，则返回正整数，
        如果当前对象this小于形参对象obj，则返回 负整数，
        如果当前对象this等于形参对象obj，则返回零。
    4.对于自定义类：如果需要排序，我们可以自定义实现Compareable接口 重写compareTo(obj)
        在compareTo(obj) 方法中指明如何排序

      */
    @Test
    public  void  test1(){
        String [] arr= new String[]{"aa","cc","gg","AA"};

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        Goods [] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaoMiMouse",12);
        arr[3] = new Goods("huaWeiMouse",65);
        arr[4] = new Goods("microsoftMouse",43);

        Arrays.sort(arr);

        System.out.println(arr);

    }



    /*
    Comparator接口的使用举例：定制排序
    1.背景：当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
     或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，
     那么可以考虑使用 Comparator 的对象来排序
    2.重写compare(Object o1,Object o2)方法，比较o1和o2的大小：
      如果方法返 回正整数，则表示o1大于o2；
      如果返回0，表示相等；
      返回负整数，表示 o1小于o2。

     */
    @Test
    public void test3(){
        String [] arr= new String[]{"aa","cc","gg","AA"};
        Arrays.sort(arr, new Comparator() {
            //按照字符串从大到小的顺序排列
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String){
                    String s1 = (String)o1;
                    String s2 = (String)o1;
                    return -s1.compareTo(s2);
                }
//                return 0;
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
    }


    @Test
    public void test4(){
        Goods [] arr = new Goods[6];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaoMiMouse",12);
        arr[3] = new Goods("huaWeiMouse",65);
        arr[4] = new Goods("microsoftMouse",43);
        arr[3] = new Goods("huaWeiMouse",224);

        Arrays.sort(arr,new Comparator(){
            //指明商品比较大小的方式:按照产品名称从低到高排序,在按照价格从高到低排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods){
                    Goods goods1 = (Goods) o1;
                    Goods goods2 = (Goods) o2;
                    if (goods1.getName().equals(goods2.getName())){
                        return -Double.compare(goods1.getPrise(), goods2.getPrise());
                    }else {
                        goods1.getName().compareTo(goods2.getName());
                    }
                }
//                return 0;
                throw new RuntimeException("输入的数据类型不一致");
            }

        });

        System.out.println(arr);
    }

}
