package com.fjq.java;

/**
 *
 * 例子：创建三个窗口卖票，总票数100张  使用实现Runnable接口来实现
 * 存在线程安全，待解决
 *
 * @author EnvyL
 * @create 2021-03-31-12:25 下午
 * @class 卖票窗口使用Runnable接口
 */

class TicektWindow implements  Runnable{

    private int ticket  = 100;
    @Override
    public void run() {
        while (true){
            if (ticket >= 1){
                System.out.println(Thread.currentThread().getName() + ": 卖票 票号" + ticket );
                ticket--;
            }else {
                break;
            }
        }
    }
}



public class WindowTest1 {
    public static void main(String[] args) {
        TicektWindow w1 = new TicektWindow();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
