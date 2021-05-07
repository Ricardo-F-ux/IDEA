package com.fjq.java;

/**
 * @author EnvyFL
 * @create 2021-04-10-10:30 上午
 * @class 商品类
 */
public class Goods implements Comparable {
    private String name;
    private double prise;

    public Goods() {
    }

    public Goods(String name, double prise) {
        this.name = name;
        this.prise = prise;
    }

    public String getName() {
        return name;
    }

    public double getPrise() {
        return prise;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", prise=" + prise +
                '}';
    }


    //指明商品比较大小的方式:按照价格从低到高排序,在按照产品名称从低到高
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            if (this.prise > goods.prise) {
                return 1;
            } else if (this.prise < goods.prise){
                return -1;
            }
//            return 0;
            return  this.name.compareTo(goods.name);
        }
        throw new RuntimeException("传入的数据类型不一致");
    }
}
