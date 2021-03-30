package cn.ly.lamada;



import java.util.function.Consumer;
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
     * 一个参数没有返回值
     */
    public void test1() {
        String x = "1";
        Consumer con = (m) -> System.out.println(m);
        con.accept(x);
    }


    /**
     * 一个参数  有返回值的
     * Predicate 判断年龄是否合法
     */
    public void PredicatedAge() {
        Predicate<User> checkage = (user) -> user.getAge() > 0;
        User user = new User();
        checkAge(user, checkage);
    }

    /***
     *  是用Function<T,R,u>实例化出对象
     */
    public void Function() {
        Function<String, User> conductor = User::new;
        Consumer<User> con2 = (x) -> x.getAge();
        User u = conductor.apply("lynx");
        //checkAge(u,);
    }


    public void checkAge(User user, Predicate<User> predicate) {
        if (predicate.test(user)) {
            System.out.println("合法！");
        } else {
            System.out.println("年龄不合法");
        }
    }

}

