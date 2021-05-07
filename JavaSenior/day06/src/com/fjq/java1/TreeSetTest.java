package com.fjq.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author EnvyFL
 * @create 2021-04-14-4:07 下午
 * @class
 */
public class TreeSetTest {

    /*
    1.向TreeSet中添加的数据，要求是相同类的对象
    2.两种排序方式，自然排序(实现和comparable接口）和 定制排序


    3.自然排序中，比较两个对象是否相同的标准为：compareTo() 返回0，不再是equals()
    4.定制排序中，比较两个对象是否相同标准： compare()返回0，不再是equals()


     */

    @Test
    public void test1() {
        TreeSet treeSet = new TreeSet();

        //失败，不能添加不同类的对象
//        treeSet.add(123);
//        treeSet.add(456);
//        treeSet.add("AA");
//        treeSet.add(new Person("Tom",13));
//        treeSet.add(123);

        //举例一
//        treeSet.add(123);
//        treeSet.add(3);
//        treeSet.add(1243);
//        treeSet.add(12543);
//        treeSet.add(323);

        //举例二
        treeSet.add(new User("Tom", 13));
        treeSet.add(new User("Jerry", 23));
        treeSet.add(new User("Jake", 33));
        treeSet.add(new User("Rose", 43));
        treeSet.add(new User("Jack", 53));


        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }


    @Test
    public void test2() {
        Comparator com = new Comparator() {
            //按照年龄从小到大排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());

                } else {
                    throw new RuntimeException("输入数据不一致");
                }
            }
        };

        TreeSet treeSet = new TreeSet(com);
        treeSet.add(new User("Tom", 13));
        treeSet.add(new User("Jerry", 23));
        treeSet.add(new User("Jake", 33));
        treeSet.add(new User("Rose", 43));
        treeSet.add(new User("Jack", 53));


        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}




