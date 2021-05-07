package com.fjq.java;
/**
 * 多线程的创建 方式一：继承于Thread类
 *  1.创建一个继承与Thread类的子类
 *  2.重写Thread类的run() --> 将此线程执行的操作声明在run()中
 *  3.创建Thread类的子类对象
 *  4.通过此对象调用start()
 * <p>
 *  例子： 遍历100以内的所有偶数
 *
 *
@author EnvyL
@create 2021-03-30-10:58 下午
@method
*/
//  创建一个继承于Thread类的子类
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        //3.创建Thread类的子类对象
         MyThread t1 = new MyThread();

        //4.通过此对象调用start(): 1、启动当前线程 2、调用当前线程的run()
            t1.start();
            //问题一 我们不能通过直接调用run()的方式启动线程
//          t1.run();

        //问题二 在启动一个线程 遍历100以内的偶数  不可以还让已经start()的线程去执行
//        t1.start();
        //我们需要重写常见一个Thread对象
        MyThread t2 = new MyThread();
        t2.start();


        //如下操作仍然是在main线程中执行的
        for (int i = 0; i < 100; i++) {
            if (i % 99 == 0) {
                System.out.println(i);
            }
        }
    }
}

