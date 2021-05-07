package com.fjq.java;

/**
 *
 * 使用同步方法解决实现Runnable的线程安全问题
 *
 * 关于同步方法的总结
 *  1.同步方法仍然涉及到同步监视器，只是我们不需要显示的声明
 *  2.非静态的同步方法，同步监视器是 this
 *    静态的同步方法 同步监视器 当前类本身
 *
 *
 * @author EnvyFL
 * @create 2021-03-31-11:21 下午
 * @class
 */
    class Window2 implements  Runnable{

        private int ticket  = 100;


        @Override
        public void run() {
            while (true){

                show();

                }
            }
    private synchronized void show() { //同步监视器 this
            //synchronized(this){
        if (ticket > 0) {

//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

            System.out.println(Thread.currentThread().getName() + ": 卖票 票号" + ticket);
            ticket--;
        }
    }

}

    public class WindowTest2 {
        public static void main(String[] args) {
            Window2 w1 = new Window2();

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

