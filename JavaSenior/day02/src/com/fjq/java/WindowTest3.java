package com.fjq.java;

/**
 * 使用同步方法来解决继承类的线程安全问题
 *
 *
 * @author EnvyFL
 * @create 2021-03-31-11:32 下午
 * @class
 */
class  Window3 extends  Thread{

    private static int ticket = 100;

    private static  Object obj = new Object();

    @Override
    public void run() {
        while(true){
//             synchronized(obj){
            show();
        }
    }

   // private synchronized void show(){  错误的
   private static synchronized void show(){//Window4.class
        if (ticket > 0){

            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ": 卖票，票号为" + ticket );
            ticket--;
        }
    }

}



public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w1 = new Window3();
        Window3 w2 = new Window3();
        Window3 w3 = new Window3();


        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();


    }
}

