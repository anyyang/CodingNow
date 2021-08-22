package cn.ly.manyThread.callback;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {


    /**
     *  Future 异步线程有个最大问题就是调用get方法的时候 会阻塞。
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {
        //这种方式 get如果不放到最后调用 会被阻塞。 就是如果
      //  test1();
        //修改test1  采用轮询才替代阻塞
        test2();
    }


    public static void test1() throws Exception {
        //创建异步执行任务
        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
            System.out.println("future Task sleep!");
            Thread.sleep(20000);
            return 1;
        });
        //开启后台辅助线程
        Thread thread = new Thread(futureTask, "threadName");
        thread.start();
        //此处开始阻塞。 Future中main
        Integer result = futureTask.get();
        System.out.println(result);
        System.out.println("mainThread------");

    }


    public static void test2() throws Exception {
        //创建异步执行任务
        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
            System.out.println("future2 Task sleep!");
            Thread.sleep(20000);
            return 1;
        });
        //开启后台辅助线程
        Thread thread = new Thread(futureTask, "threadName");
        thread.start();
        System.out.println("mainThread------");
        boolean flag = true;
        while (flag) {
            if (futureTask.isDone()) {
                flag = false;
                System.out.println("异步线程执行完毕");
            }else{
                Thread.sleep(1000);
                System.out.println("异步线程执行完了吗？");
            }
        }
    }
}
