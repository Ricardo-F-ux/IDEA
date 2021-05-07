package com.fjq.java;


import org.junit.Test;

/**
 * @author EnvyFL
 * @create 2021-04-07-11:01 下午
 * @class
 */
public class IDEADebug {

    @Test
    public void testStringBuffer() {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);//

        System.out.println(sb.length());//4

        System.out.println(sb);//"null"

        StringBuffer sb1 = new StringBuffer(str);//抛异常NullPointerException
        System.out.println(sb1);//
    }
}
