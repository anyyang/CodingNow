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

    public FooBar(int n) {
        this.n = n;

    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            printFoo.notifyAll();
            printFoo.wait();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.wait();
            printBar.run();
            printBar.notifyAll();
        }
    }
}