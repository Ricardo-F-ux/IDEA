package com.fjq.java2;

/**
 * 线程通信的应用：经典例题：生产者/消费者问题
 *
 * @author EnvyFL
 * @create 2021-04-06-10:37 下午
 * @class
 */
class Clerk{
    private int empty = 0;

    //生产产品
    public void produceProduct() {
        synchronized (this){
            if(empty < 20){
                empty++;
                System.out.println(Thread.currentThread().getName() + "：开始生产第"+empty+"个产品");

            }else {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    //消防产品
    public  synchronized void  consumProduct() {
        if(empty > 0){
            System.out.println(Thread.currentThread().getName() + ":开始消费第"+ empty+"个产品");
            empty--;

            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        notify();
    }
}

class Producer extends  Thread{ //生产者
    private Clerk clerk;

    public Producer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + "开始生产产品");
        while (true){

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.produceProduct();
        }
    }
}

class Consumer extends Thread{ //消费者
    private Clerk clerk;

    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + "开始消费产品");
        clerk.consumProduct();
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("生产者一");

        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者一");

        p1.start();
        c1.start();
    }
}

