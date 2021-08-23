package cn.ly.manyThread.threadSafe;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
   对象锁 对对象方法或者本身
 */
class User {
    public synchronized void sayHello() {
        System.out.println("Hello拿不到锁，好尴尬呀，只能等goods释放对象锁");
    }

    public synchronized void writeGood() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Goods 写得方法是上锁得，所以我不释放锁，谁也别想访问");
    }

    public static synchronized void look() {
        System.out.println(" look 方法是静态方法锁住了类，和对象锁不冲突，所以不耽误我看美女");
    }

    public void runOnRoad() {
        System.out.println("跑步得方法是普通方法，所以不会被上锁,所以直接跑了");
    }
}

public class SynInstanceLockTest {
    public static void main(String[] args) {
        User user = new User();

        new Thread(() -> {
            user.writeGood();
        }).start();
        System.out.println("---MainThreadIsRun-----");
        new Thread(() -> {
            user.sayHello();
        }).start();
        new Thread(() -> {
            user.runOnRoad();
        }).start();
        new Thread(() -> {
            User.look();
        }).start();
    }
}
