package com.fjq.java2;

import com.fjq.java.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的方法结构
 *
 * @author EnvyFL
 * @create 2021-04-24-9:32 上午
 * @class
 */
public class MethodTest {

    @Test
    public void test1(){
        Class clazz = Person.class;

        //getMethods()：获取当前运行时类及其父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method m: methods) {
            System.out.println(m);
        }

        //getDeclaredMethods()：获取当前运行时类当中声明的所有方法（不包含父类中声明的方法）
        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method m: methods1
             ) {
            System.out.println(m);
        }

    }


    /*
    @XXX
    权限修饰符 返回值类型 方法名（参数类型1，形参名1...)throws Exception{}
     */
    @Test
    public void test2(){
        Class clazz = Person.class;
        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method m: methods1) {
            //1.获取方法声明的注解
            Annotation[] annos = m.getAnnotations();
            for (Annotation a: annos) {
                System.out.println(a);
            }

            //2.权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) +"\t");
            System.out.println();

            //3.返回值类型
            System.out.println(m.getReturnType() +"\t");
            System.out.println();

            //4.方法名
            System.out.println(m.getName());
            System.out.println("(");

            //5.形参列表
            Class [] parameterType =  m.getParameterTypes();
            if (!(parameterType == null && parameterType.length == 0)){
                for (Class p: parameterType) {
                    System.out.println(p.getName() +"args_" );
                }
            }

            System.out.println(")");

            //6.抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            System.out.print(exceptionTypes +"\t");

            System.out.println();

        }



    }

}
