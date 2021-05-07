package com.fjq.java;

/**
 *
 * 例子：创建三个窗口卖票，总票数100张  使用继承Thread类实现的
 *
 * 存在线程安全问题
 *
 * @author EnvyL
 * @create 2021-03-31-8:45 上午
 * @class
 */
class  Window extends  Thread{

    private static int ticket = 100;

    @Override
    public void run() {
        while(true){
            if (ticket > 0){
                System.out.println(Thread.currentThread().getName() + ": 卖票，票号为" + ticket );
                ticket--;
            }else {
                break;
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
