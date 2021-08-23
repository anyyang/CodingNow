package cn.ly.manyThread.callback;

/**
 * 守护线程，一种特殊的后台线程，可以用来垃圾回收记录日志等，生命周期伴随主线程消亡而消亡
 * 用户线程 平时干活的线程，程序默认至少会有一个用户线程保证程序的运行
 */
public class DaemonThread {

    public static void main(String[] args) {
        //主线程不会等守护线程
        test1();
        //主线程会等守护线程
        test2();
    }

    /**
     * 守护线程  特点 ： 主线程退出后是不等守护线程的。 所以这边直接就退出了。
     */
    private static void test1() {
        Thread mainThread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("守护进程在此");
        }, "daemon Thread-1");
        //设置为 true为守护线程
        mainThread.setDaemon(true);
        mainThread.start();
        System.out.println("mainThread");
    }

    /**
     * 守护线程   主线程等守护线程退出后 才给退出
     */
    private static void test2() {
        Thread mainThread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("守护进程在此");
        }, "daemon Thread-1");
        //设置为 true为守护线程
        mainThread.setDaemon(true);
        mainThread.start();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("mainThread");
    }

}
