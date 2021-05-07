package com.fjq.exer;

/**
 * 练习：创建两个分线程，其中一个线程遍历100以内的偶数，其中一个线程遍历100以内的奇数
 *
 *
 *
@author EnvyL
@create 2021-03-30-11:27 下午
@method
*/
class MyThread2 extends  Thread{
    @Override
    public void run() {
        for (int i = 0 ;i <= 100;i++){
            if (i % 2==0){
                System.out.println(Thread.currentThread().getName() + ":"+i);
            }
        }
    }
}

class MyThread1 extends  Thread{
    @Override
    public void run() {
        for (int i = 0 ;i <= 100;i++){
            if (i % 2 !=0){
                System.out.println(Thread.currentThread().getName() + ":"+i);
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
//        MyThread1 demo1 = new MyThread1();
//        MyThread2 demo2 = new MyThread2();
//
//        demo1.start();
//        demo2.start();
        //创建Thread类的匿名子类的方式
        new Thread(){
            @Override
            public void run() {
                for (int i = 0 ;i <= 100;i++){
                    if (i % 2 !=0){
                        System.out.println(Thread.currentThread().getName() + ":"+i);
                    }
                }
            }
            }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0 ;i <= 100;i++){
                    if (i % 2==0){
                        System.out.println(Thread.currentThread().getName() + ":"+i);
                    }
                }
            }
        }.start();
    }

}
