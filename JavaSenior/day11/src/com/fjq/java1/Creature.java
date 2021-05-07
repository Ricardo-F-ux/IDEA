package com.fjq.java1;

import java.io.Serializable;

/**
 * @author EnvyFL
 * @create 2021-04-23-11:25 下午
 * @class
 */
public class Creature <T> implements Serializable {

    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("吃东西");
    }

}
