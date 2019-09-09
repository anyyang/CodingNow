package cn.ly.leetcode.Mid.Sep9;

import java.util.concurrent.CountDownLatch;

/**
 * Created by  liuyang
 * 2019/9/9    14:08
 * cn.ly.leetcode.Mid.Sep9
 * All Right Reserved by liuyang.
 **/

class FooBar {
    private int n;
    private CountDownLatch countDownLatchA;
    private CountDownLatch countDownLatchB;



    public FooBar(int n) {
        this.n = n;
        countDownLatchA = new CountDownLatch(n);
        countDownLatchB = new CountDownLatch(n);
        try {
            countDownLatchB.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            countDownLatchA.countDown();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            countDownLatchB.await();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            countDownLatchB.countDown();
            // printBar.run() outputs "bar". Do not change or remove this line.

            printBar.run();
            countDownLatchA.await();
        }
    }
}