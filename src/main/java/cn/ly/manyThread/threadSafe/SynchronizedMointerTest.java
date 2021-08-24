package cn.ly.manyThread.threadSafe;

public class SynchronizedMointerTest {
    final Object obj = new Object();

    public void c1() {
        synchronized (obj) {
            System.out.println("aaa");
        }
    }

}
