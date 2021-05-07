package com.fjq.exer;

/**
 * 一道面试题
 *
 *
 * @author EnvyFL
 * @create 2021-04-07-10:42 上午
 * @class
 */
public class StringTest {
    String str = new String("good");
    char[] ch = {'t','e','s','t'};

    public  void change(String str,char[] ch){
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str);//good
        System.out.println(ex.ch);//best
    }
}
