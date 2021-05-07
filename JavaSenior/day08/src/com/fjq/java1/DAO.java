package com.fjq.java1;

import java.util.List;

/**
 * @author EnvyFL
 * @create 2021-04-20-10:43 下午
 * @class
 *
 * DAO:data(base)access object
 */
public class DAO <T> {//表的共性操作的DAO

    //添加一条记录
    public void add(T t){

    }

    //删除一条记录
    public boolean remove(int index){
        return false;
    }

    //修改一条记录
    public void update(int index,T t){

    }

    //查询一条记录
    public List<T> getIndex(int index){
        return null;
    }

    //查询多条记录
    public List<T> getForList(int index){
        return null;
    }


    //泛型方法
    //举例：获取表中有多少条记录？获取最大的员工的入职时间？
    public <E> E getValue(){
        return  null;
    }

}
