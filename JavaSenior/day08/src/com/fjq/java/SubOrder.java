package com.fjq.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EnvyFL
 * @create 2021-04-20-2:29 下午
 * @class
 */
public class SubOrder extends Order<Integer>{//SubOrder:不是泛型类
    public  <E>  List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for (E e: list) {
            list.add(e);
        }
        return list;
    }

}
