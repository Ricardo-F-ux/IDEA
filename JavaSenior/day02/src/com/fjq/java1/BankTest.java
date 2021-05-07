package com.fjq.java1;

/**
 *
 *  使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 *
 * @author EnvyFL
 * @create 2021-04-01-3:42 下午
 * @class
 */
public class BankTest {
}

class Bank{
  private   Bank(){

  }

  private static  Bank instacnce = null;

  private  static  Bank getInstacnce(){
      //方式一、效率稍差
//     synchronized(Bank.class){
//         if(instacnce != null){
//             instacnce = new Bank();
//         }
//         return  instacnce;
//     }
      //方式二：
        if (instacnce == null) {
            synchronized (Bank.class) {
                if (instacnce != null) {
                    instacnce = new Bank();
                }

            }
        }
      return instacnce;
  }


}
