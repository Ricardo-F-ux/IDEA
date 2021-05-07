package com.fjq.java2;

import com.fjq.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性结构
 *
 *
 * @author EnvyFL
 * @create 2021-04-24-9:19 上午
 * @class
 */
public class FieldTest {

    @Test
    public void test1(){

        Class clazz1 = Person.class;

        //获取属性结构
        //getFields()：获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz1.getFields();
        for ( Field f : fields) {
            System.out.println(f);
        }

        //getDeclaredFields():获取当前运行时类当中声明的所有属性（不包含父类中声明的属性）
        Field []fields1  = clazz1.getDeclaredFields();
        for (Field f1: fields1) {
            System.out.println(f1);
        }


    }


    //权限修饰符，数据类型，变量名
    @Test
    public void test2(){
        Class clazz1 = Person.class;
        Field []fields1  = clazz1.getDeclaredFields();
        for (Field f1: fields1) {
            //1.权限修饰符
            int modifier =  f1.getModifiers();
            System.out.print(Modifier.toString(modifier) +"\t");

            //2.数据类型
            Class type =  f1.getType();
            System.out.print(type.getName() + "\t");

            //3.变量名
            String fName = f1.getName();
            System.out.println(fName);
            System.out.println();



        }

    }
}
