package com.fjq.java1;

/**
 * @author EnvyFL
 * @create 2021-04-14-3:26 下午
 * @class
 */
public class User implements  Comparable{
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getAge() != user.getAge()) return false;
        return getName() != null ? getName().equals(user.getName()) : user.getName() == null;
    }

    @Override
    public int hashCode() { //return name.hashCode() + age;
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getAge();
        return result;
    }

    //按照姓名从大到小排序,年龄从小到大排序
    @Override
    public int compareTo(Object o) {
        if (o instanceof User){
            User user = (User) o;
//            return -this.name.compareTo(user.name);
            int compare =  -this.name.compareTo(user.name);
            if (compare != 0){
                return  -this.name.compareTo(user.name);
            }else {
                return Integer.compare(this.age,user.age);
            }
        }
        throw new RuntimeException("输入类型不匹配");
    }
}
