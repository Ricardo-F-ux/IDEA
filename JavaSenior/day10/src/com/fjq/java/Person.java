package com.fjq.java;

import java.io.Serializable;

/**
 * Person需要满足以下要求,方可序列号
 * 1.需要实现接口：Serializable
 * 2.当前类提供一个全局常量：serialCVersionUID
 * 3.除了当前Person类需要实现serialCVersionUID接口之外，还必须保证其内部所有属性
 *   也必须是可序列化的。（默认情况下，基本数据类型可序列化的）
 *
 *
 * 补充：ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 *
 * @author EnvyFL
 * @create 2021-04-22-3:39 下午
 * @class
 */
public class Person implements Serializable {

    public static final long serialCVersionUID = 4754635345321L;

    private String  name;
    private int age;
    private  Account acct;

    public Person() {
    }

    public Person(String name, int age, Account acct) {
        this.name = name;
        this.age = age;
        this.acct = acct;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", acct=" + acct +
                '}';
    }
}

class Account implements Serializable{

    public static final long serialCVersionUID = 47454635345321L;


    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }

    public Account() {
    }
}
