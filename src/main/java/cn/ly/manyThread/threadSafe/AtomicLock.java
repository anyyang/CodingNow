package cn.ly.manyThread.callback.threadSafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1 atomic 实现原理基于cas 比较和更换 内存中的数据。如果相同则用新版本更换
 * 2 copmareAndSet方法核心思想在于内存偏移
 * 3 会出现ABA的问题。解决方法是 AtomicStampedRefrence 建立版本号确保CAS完整性
 */

public class AtomicLock {
    public static void main(String[] args) {
      // AtomicStampedReference
       // Arrays.sort();
        AtomicInteger  atomicInteger = new AtomicInteger(10);
        Integer a1=  atomicInteger.addAndGet(1);
        System.out.println(a1);
        Integer a2 =  atomicInteger.getAndSet(2);
        System.out.println(a2);
        System.out.println(atomicInteger);
    }
}
