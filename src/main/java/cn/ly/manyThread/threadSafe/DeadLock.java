package cn.ly.manyThread.threadSafe;

public class DeadLock {
    Object a = new Object();
    Object b = new Object();


    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        deadLock.t1();
    }

    public void t1() {

        new Thread(() -> {
            synchronized (a) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //爷卡住了
                synchronized (b){
                    System.out.println("爷蚌埠住了");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (b) {
                synchronized (a){
                    System.out.println("爷蚌埠住了");
                }
            }
        }).start();

    }

}
