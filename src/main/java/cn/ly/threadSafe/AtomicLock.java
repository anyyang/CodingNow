package cn.ly.threadSafe;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicLock {
    public static void main(String[] args) {
       // Arrays.sort();
        AtomicInteger  atomicInteger = new AtomicInteger(10);
        Integer a1=  atomicInteger.addAndGet(1);
        System.out.println(a1);
        Integer a2 =  atomicInteger.getAndSet(2);
        System.out.println(a2);
        System.out.println(atomicInteger);
    }
}
