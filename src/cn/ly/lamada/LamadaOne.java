package cn.ly.lamada;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author liuyang
 * @date 2020/5/20 13:46
 * @email liu.yang@autoyong.com
 * @
 */
public class LamadaOne {
    /**
     * Predicate 判断年龄是否合法
     */
    @Test
    public void PredicatedAge() {
        Predicate<User> checkage = (user)->user.getAge()>0;
        User user = new User();
        checkAge(user,checkage);
    }

    /***
     *  是用Function<T,R,u>实例化出对象
     */
    @Test
    public void Function(){
        Function<String, User> conductor =User::new;
         User u = conductor.apply("lynx");
         //checkAge(u,);
    }





    public void checkAge(User user, Predicate<User> predicate){
        if(predicate.test(user)){
            System.out.println("合法！");
        }else{
            System.out.println("年龄不合法");
        }
    }

}

class User {
    public User(){}
    public User(String name){
        this.name=name;
        this.age=33;
    }
    public User(String name , int age){
        this.age=age;
        this.name=name;
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
