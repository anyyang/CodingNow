package cn.ly.lamada;/*
 *@program:CodingNow
 *@author: liuyang
 *@since: 2021/2/26  12:23
 *@Description:
 */

public class User {
    public User() {
    }

    public User(String name) {
        this.name = name;
        this.age = 33;
    }

    public User(String name, int age) {
        this.age = age;
        this.name = name;
    }

    private String name;

    private int age;

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


}
