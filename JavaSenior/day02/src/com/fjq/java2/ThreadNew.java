package com.fjq.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现callable接口 --> JDK5.0新增
 *
 *
 * 如何理解实现callable接口的方式创建多线程比实现Runnable接口创建多线程强大？
 * 1.call()可以有返回值的。
 * 2.call()可以抛出异常，被外面的操作捕获，获取异常信息
 * 3.callabl是支持泛型的
 *
 *
 * @author EnvyFL
 * @create 2021-04-06-11:05 下午
 * @class
 */

//穿件一个实现callable的实现类
class NumThread implements Callable{
    //2实现call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i =0 ; i <= 100; i++){
            if (i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadNew {
    public static void main(String[] args) {
        //3创建callable接口实现类的对象
        NumThread n  =new NumThread();
        //4将此callable接口实现类的对象作为传递到FutureTask的构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(n);
        //5将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        new Thread(futureTask).start();

        try {
            //6获取callable中call方法的返回值
            //get()返回值即为FutureTask构造器参数callable实现类重写call()返回值
           Object sum =  futureTask.get();
            System.out.println("总和为" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
