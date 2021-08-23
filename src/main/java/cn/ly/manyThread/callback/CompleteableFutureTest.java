package cn.ly.manyThread.callback;

import java.util.concurrent.*;

public class CompleteableFutureTest {


    public static void main(String[] args) {
        // 测试 异步使用是线程池
        //testCompletableFuture();
        // 测试异步获取返回结果
        testCompletionStage();

    }

    /**
     * 异步任务使用线程池
     */
    public static void testCompletableFuture() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new ArrayBlockingQueue(10));
        // runAsync 运行异步没有返回值的
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("自己提供的线程池ThreadName:" + Thread.currentThread().getName());
        }, threadPoolExecutor);
        threadPoolExecutor.shutdown();
        //线程池
        CompletableFuture<Void> futureNotPool = CompletableFuture.runAsync(() -> {
            System.out.println("默认提供线程池ThreadName:" + Thread.currentThread().getName());
        });
        threadPoolExecutor.shutdown();
    }

    /**
     * 异步任务的调度编排
     */
    public static void testCompletionStage() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new ArrayBlockingQueue(10));

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("自己提供的线程池ThreadName:" + Thread.currentThread().getName());
            return 888;
        }, threadPoolExecutor)
                .thenApplyAsync((x) -> {
                    x = 5 / 0;
                    return x + 5;
                }).whenComplete((x, e) -> {
                    if (e != null) {
                        e.printStackTrace();
                    }
                }).exceptionally(e -> {
                    e.printStackTrace();
                    return -100;
                });
        try {
            Integer i = future.get();
            System.out.println(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        threadPoolExecutor.shutdown();

    }

}
