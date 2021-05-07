package com.fjq.java2;

import com.fjq.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author EnvyFL
 * @create 2021-04-24-9:58 上午
 * @class
 */
public class OtherTest {

    /*
    获取构造器

     */
    @Test
    public void test1() {
        Class clazz = Person.class;
        //getConstructors():当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }

        System.out.println();
        //getDeclaredConstructors()：获取当前运行时类中声明的所有构造器
        Constructor[] constructors1 = clazz.getDeclaredConstructors();
        for (Constructor c : constructors1) {
            System.out.println(c);
        }

    }

    /*
    获取运行时类的父类
     */
    @Test
    public void test2() {
        Class clazz = Person.class;

        Class superClass = clazz.getSuperclass();
        System.out.println(superClass);

    }

    /*
  获取运行时类带泛型的父类
   */
    @Test
    public void test3() {
        Class clazz = Person.class;

        Type genericSuperClass = clazz.getGenericSuperclass();
        System.out.println(genericSuperClass);

    }

    /*
    获取运行时类带泛型的父类的泛型

    代码：逻辑型代码 VS 功能性代码
    */
    @Test
    public void test4() {
        Class clazz = Person.class;

        Type genericSuperClass = clazz.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType)genericSuperClass;
        //获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
//        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(actualTypeArguments[0].getTypeName());

    }


    /*
    获取运行时类实现的借口
    */
    @Test
    public void test5() {
        Class clazz = Person.class;

        Class[] interfaces= clazz.getInterfaces();
        for (Class c:interfaces) {
            System.out.println(c);
        }

        System.out.println();
        //获取运行时类的父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class c:interfaces1) {
            System.out.println(c);
        }

    }


     /*
    获取运行时类所在的包
    */
    @Test
    public void test6(){
        Class clazz = Person.class;

        Package pack = clazz.getPackage();
        System.out.println(pack);

    }

    /*
  获取运行时类声明的注解
  */
    @Test
    public void test7(){
        Class clazz = Person.class;

        Annotation[]  annotations= clazz.getAnnotations();
        for (Annotation c:annotations ) {
            System.out.println(c);
        }
    }

}
