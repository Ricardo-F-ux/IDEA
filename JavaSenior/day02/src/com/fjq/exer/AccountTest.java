package com.fjq.exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author EnvyFL
 * @create 2021-04-06-2:26 下午
 * @class
 */

class Account{
    private  double balance ;
    ReentrantLock lock = new ReentrantLock();

    Account(double balance){
        this.balance = balance;
    }
    //存钱
    public void deposit(double amt){
        try {
            lock.lock();
            if (amt > 0){
                balance += amt;

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"存钱成功 余额为：" + balance);
            }
        }finally {
            lock.unlock();
        }

    }

}
class Customer extends Thread{
    private  Account acct;

    public Customer(Account acct){
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0;i < 3; i++){
            acct.deposit(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}
