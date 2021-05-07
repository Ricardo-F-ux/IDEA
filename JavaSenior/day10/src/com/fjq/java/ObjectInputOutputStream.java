package com.fjq.java;


import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 * 1.ObjectInputStream 和 ObjectOutputStream
 * 2.作用：用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可 以把Java中的对象写入到数据源中，
 *         也能把对象从数据源中还原回来
 *
 * 3.要想一个Java对象是可序列号的，需要满足相应的要求
 *
 * 4.序列化机制：对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种二进制流持久地保存在磁盘上，
 *   或通过网络将这种二进制流传 输到另一个网络节点。 //当其它程序获取了这种二进制流，就可以恢复成原 来的Java对象
 * @author EnvyFL
 * @create 2021-04-22-3:28 下午
 * @class
 */
public class ObjectInputOutputStream {

    /*
    序列化过程：将内存中的Java对象保存到磁盘中或通过网络传输出去
    使用ObjectOutputStream实现
     */
    @Test
    public void testObjectOutputStream(){
        ObjectOutputStream oos = null;
        try {
            //1.
            oos = new ObjectOutputStream(new FileOutputStream("Object.dat"));
            //2.
            oos.writeObject(new String("我爱北京天安门"));
            oos.flush();//刷新操作

            oos.writeObject(new Person("张三",23,new Account(5000)));
            oos.flush();
            //3.
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /*
    反序列号：将磁盘文件中的对象还原为内存中的一个Java对象
    使用ObjectInputStream来实现的
     */
    @Test
    public void testObjectInputStream(){

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Object1.dat"));

            Object obj = ois.readObject();
            String str = (String) obj;
            System.out.println(str);

            Person p = (Person) ois.readObject();
            System.out.println(p);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
