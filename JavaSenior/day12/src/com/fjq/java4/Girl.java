package com.fjq.java4;

/**
 * @author EnvyFL
 * @create 2021-04-25-6:26 下午
 * @class
 */
public class Girl {

    private String name;

    public Girl(String name) {
        this.name = name;
    }

    public Girl() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}
