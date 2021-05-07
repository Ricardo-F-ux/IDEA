package com.fjq.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历操作，使用迭代器Iterator接口
 *  1、内部方法：next()遍历操作 hasNext()查询集合是否还有对象
 *  2、集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合 的第一个元素之前。
 *  3、内部定义了remove(),可以在遍历的时候，删除集合中的元素，此方法不同于集合直接调用remove()
 *
 * @author EnvyFL
 * @create 2021-04-13-8:04 上午
 * @class
 */
public class IteratorTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Person("Jerry", 20));
        coll.add(false);

        Iterator iterator = coll.iterator();
        //方式一：
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
        //抛异常 NoSuchElementException
//        System.out.println(iterator.next());

        //方式二：不推荐
//        System.out.println(coll.size());
//        for (int i = 0 ;i < coll.size(); i++){
//            System.out.println(iterator.next());
//        }

        //方式三：推荐
        while (iterator.hasNext()) { //hasNext():判断是否还有下一个元素
            //next()：①指针下移 ②将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Person("Jerry", 20));
        coll.add(false);

        Iterator iterator = coll.iterator();

        //错误方式一：
//        while (iterator.next() != null){
//            System.out.println(iterator.next());
//        }

        //错误方式二：集合对象每次调用iterator()方法都得到一个全新的迭代器对象
//        while (coll.iterator().hasNext()){
//            System.out.println(iterator.next());
//        }
    }


    //测试Iterator中的remove()
    //如果还未调用next()或在上一次调用 next 方法之后已经调用了 remove 方法，
    // 再调用remove都会报IllegalStateException。
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Person("Jerry", 20));
        coll.add(false);

        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            Object object = iterator.next();
            if ("Tom".equals(object)){
                iterator.remove();
            }
        }

        //遍历集合
        Iterator iterator1 = coll.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}