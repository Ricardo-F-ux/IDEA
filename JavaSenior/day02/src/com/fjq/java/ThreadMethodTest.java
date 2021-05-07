package com.fjq.java;
/**
 * 测试Thread中常用的方法
 * 1.start(); 启动当前线程 调用当前run()方法
 * 2.run(); 通常需要重写Thread类中的此方法，将创建线程的操作声明在此方法中
 * 3.currentThread();静态方法 返回执行当前代码的线程
 * 4.getName(); 获取当前线程的名字
 * 5.setName(); 设置当前线程的名字
 * 6.yield(); 释放当前CPU的执行权
 * 7.jion(); 在线程a中调用线程b的join方法，此时线程a就进入阻塞状态（block） 直到线程b完全执行完成 线程a才结束阻塞状态
 * 8.stop(); 已过时。当执行此方法时，强制结束当前线程
 * 9.sleep(long milltime); 让当前线程阻塞指定的milltime毫秒。在指定的milltime毫秒时间内 处于阻塞状态
 * 10.isAlive();
 *
 *
 * 线程的优先级
 * 1.
 * MAX_PRIORITY: 10;
 * MIN_PRIORITY: 1;
 * NORM_PRIORITY: 5 --> 默认优先级
 * 2.如何设置和获取当前线程的优先级：
 * getPriority(); 获取
 * setPriority(int p); 设置
 *
 *      说明：高优先级的线程要抢占低优先级线程cpu的执行权 但是只从概率上说 高优先级线程高概率的情况下被执行。
 *           并不意味着只有当高优先级的线程执行完了 低优先级的线程才执行。
 *
 * @author EnvyL
 * @create 2021-03-31-7:55 上午
 */
class HelloThread extends  Thread{

    @Override
    public void run() {
        for (int i = 0; i <=100;i++){
            if (i % 2 == 0){

                try {
                   Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ":" +Thread.currentThread().getPriority()+ i);
            }
//            if (i % 20 == 0){
//                this.yield();
//            }
        }
    }

    public   HelloThread(String str){
        super(str);
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread("Thread:11");
//        h1.setName("线程一");
        h1.start();

        //给主线程命名
        Thread.currentThread().setName("主线程");

        for (int i = 0; i <=100;i++){
            if (i % 2 == 0){

                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority()+i);
            }

        if (i == 20) {
            try {
                h1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                }
            }
        }

        System.out.println(h1.isAlive());
    }
}
