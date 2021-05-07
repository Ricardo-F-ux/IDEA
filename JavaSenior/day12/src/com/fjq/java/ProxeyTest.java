package com.fjq.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理的举例
 *
 * @author EnvyFL
 * @create 2021-04-24-4:38 下午
 * @class
 */

interface Human{

    String getBelief();

    void eat(String food);

}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly!!!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

class HumanUtil{

    public void methiod1(){
        System.out.println("==============通用方法一==============");
    }
    public void methiod2(){
        System.out.println("==============通用方法二==============");
    }


}

/*
要想实现动态代理，需要解决的问题？
问题一：如何根据加载到内存中的代理类，动态的创建一个代理类及其对象
问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法


 */
class ProxyFactory{
    //调用此方法，返回一个代理类对象
    public static Object getProxeyInstance(Object obj){//obj：被代理类的
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj ;//需要使用被代理类对象进行赋值

    public void bind(Object obj){
        this.obj = obj;
    }

    //当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法 invoke()
    //将被代理类要执行的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil util =new HumanUtil();
        util.methiod1();

        //method：即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //obj：被代理类的对象
        Object returnValue = method.invoke(obj,args);

        util.methiod1();
        //上述方法的返回值就作为当前类中invoke()的返回值
        return returnValue;
    }
}

public class ProxeyTest {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        //proxeyInstance:代理类的对象
        Human proxeyInstance =(Human) ProxyFactory.getProxeyInstance(superMan);
        //当通过代理类对象调用方法时，会自动的调用被代理类中同名的方法
        String  believe =   proxeyInstance.getBelief();
        System.out.println(believe);
        proxeyInstance.eat("四川麻辣烫");


        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyClothFactory =  (ClothFactory)ProxyFactory.getProxeyInstance(nikeClothFactory);
        proxyClothFactory.produceCloth();
    }

}
