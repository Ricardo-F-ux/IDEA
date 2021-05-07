package com.fjq.java;

/**
 * 使用enum关键字定义枚举类
 *  说明：定义的枚举类默认继承与java.lang.Enum类
 *
 * @author EnvyFL
 * @create 2021-04-11-6:38 下午
 * @class
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 spring= Season1.SPRING ;
        //toString
        System.out.println(spring);

//        System.out.println(Season1.class.getSuperclass());
        System.out.println("**************************");
        //values()
      Season1[] values =  Season1.values();
      for (int i = 0; i < values.length;i++){
          System.out.println(values[i]);
          values[i].show();
      }
        System.out.println("**************************");
        Thread.State []values1 = Thread.State.values();
        for (int i = 0; i < values1.length;i++){
            System.out.println(values1[i]);
        }

        //valueOf(String objName):根据提供的objName，返回枚举类中对象名是objName的对象
        //如果没有objName的枚举类对象 则抛异常 IllegalArgumentException
        Season1 winter = Season1.valueOf("WINTER");
//       Season1 winter = Season1.valueOf("WINTER1");
        System.out.println(winter);

        winter.show();

    }
}

interface Info{
    void show();
}


//使用enum关键字定义枚举类
enum  Season1 implements Info{

    //1、提供当前枚举类对象 多个对象之间用 "," 末尾对象用分号结束
    SPRING ("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER ("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN ("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天", "冰天雪天"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };


    //2、声明Season对象的属性:用 private final 修饰
    private final String SeasonName;
    private final String seasonDesc;

    //3、私有化类的构造器，并给对象属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.SeasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }



    //4.其他诉求，获取枚举类对象的属性
    public String getSeasonName() {
        return SeasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }


    //5.其他诉求 提供toString()
    @Override
    public String toString() {
        return "Season{" +
                "SeasonName='" + SeasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }


}

