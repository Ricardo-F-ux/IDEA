package com.fjq.java;

/**
 *
 * 例子：创建三个窗口卖票，总票数100张  使用继承Thread类实现的
 *
 * 说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器
 *
 * 存在线程安全问题
 *
 * @author EnvyL
 * @create 2021-03-31-8:45 上午
 * @class
 */
class  Window extends  Thread{

    private static int ticket = 100;

    private static  Object obj = new Object();

    @Override
    public void run() {
        while(true){
//             synchronized(obj){
               synchronized(Window.class){

               if (ticket > 0){

                   try {
                       Thread.currentThread().sleep(10);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }

                   System.out.println(Thread.currentThread().getName() + ": 卖票，票号为" + ticket );
                   ticket--;
               }else {
                   break;
               }
           }

        }
    }
}



public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();


        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();


    }
}
