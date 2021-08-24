package cn.ly.manyThread.threadSafe;

public class ReEntryLock {
    /**
     * 可重入锁
     * @param args
     */
    public static void main(String[] args) {
        final Object objectLockA = new Object();

        new Thread(() -> {
            synchronized (objectLockA) {
                System.out.println("-----外层调用");
                synchronized (objectLockA) {
                    System.out.println("-----中层调用");
                    synchronized (objectLockA) {
                        System.out.println("-----内层调用");
                    }
                }
            }
        }, "a").start();
    }
}

