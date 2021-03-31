package cn.ly.jvm;

/**
 * jvm配置参数
 * <p>
 -Xmx4m -Xms4m
  去除逃逸分析
 -XX:-DoEscapeAnalysis
 -XX:+DoEscapeAnalysis 开启逃逸分析
 -XX:+PrintGCDetails
 -XX:+HeapDumpOnOutOfMemoryError
 */
public class EscapeAnalysisTest {
    public static void main(String[] args) {
        long a1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            alloc();
        }

        // 查看执行时间
        long a2 = System.currentTimeMillis();
        System.out.println("cost " + (a2 - a1) + " ms");
        // 为了方便查看堆内存中对象个数，线程sleep
        try {
            Thread.sleep(1000000);
        } catch (
                InterruptedException e1) {
            e1.printStackTrace();
        }

    }

    private static void alloc() {
        User user = new User();
    }


    static class User {
    }
}