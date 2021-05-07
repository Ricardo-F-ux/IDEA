package com.fjq.java2;

/**
 * 线程通信的例子：使用两个线程打印1-100 线程一 线程二交替打印
 *
 * 涉及到三个方法：
 * wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
 * notify():一旦执行此方法，就会唤醒一个被wait的一个线程，如果有多个线程被wait，就唤醒优先级高的那个。
 * notifyAll():一旦执行此方法，就会唤醒所有被wait的一个线程
 *
 * 说明：
 * 1.wait()、notify()、notifyAll() 三个方法必须使用在同步代码块和同步方法中
 * 2.wait()、notify()、notifyAll()三个方法的调用者必须是同步代码块和同步方法中的同步监视器，否则，会出现异常
 * 3.wait()、notify()、notifyAll()三个方法是定义在java.lang.Object中
 *
 * 面试题：sleep() 和 wait() 异同？
 *  1.相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态
 *  2.不同点：1）两个方法声明的位置都不一样：Thread类中声明sleep()，Object类中声明wait()
 *           2）调用的要求不同：sleep()可以在任何需要的场景下调用，wait()必须使用在同步代码块同步方法中
 *           3)关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep()不会释放锁，wait()会释放锁
 *
 * @author EnvyFL
 * @create 2021-04-06-2:48 下午
 * @class
 */

class Number implements Runnable {

    private int num = 1;

    @Override
    public void run() {

        while (true) {
           synchronized (this){

               notify();

               if (num <= 100) {

                    try {
                        Thread.sleep(100); //sleep不会释放锁
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }


                   System.out.println(Thread.currentThread().getName() + ":" + num);
                   num++;

                   try {
                       //使得调用如下wait()方法 线程进入阻塞状态
                       wait(); //会释放锁
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }

               }else {
                   break;
               }
           }
        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number n = new Number();
        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }
}
