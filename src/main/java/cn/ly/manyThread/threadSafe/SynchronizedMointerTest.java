package cn.ly.manyThread.threadSafe;
//Synchronized的三种实现类型
public class SynchronizedMointerTest {
    final Object obj = new Object();

    /**

     public void c1();
     descriptor: ()V
     flags: ACC_PUBLIC
     Code:
     stack=2, locals=3, args_size=1
     0: aload_0
     1: getfield      #3                  // Field obj:Ljava/lang/Object;
     4: dup
     5: astore_1
     6: monitorenter  //同步代码块实现syn使用的 moninterenter 进入到代码同步的区域
     7: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
     10: ldc           #5                  // String aaa
     12: invokevirtual #6                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     15: aload_1
     16: monitorexit  //  monitorexit 第一次退出
     17: goto          25
     20: astore_2
     21: aload_1
     22: monitorexit // moniterexit 第二次退出 这次是保底的退出，如果有异常了  从此处退出
     23: aload_2
     24: athrow
     25: return
     */
    public void c1() {
        synchronized (obj) {
            System.out.println("aaa");
        }
    }
    //注意 静态的synchronized 和动态的synchronized不是同一把锁。 当然和普通方法也互不影响
   // 通过再方法上标识 ACC_SYNCHRONIZED 来表明这是一个同步方法
   //flags: ACC_PUBLIC, ACC_SYNCHRONIZED
    public synchronized void  test(){
        System.out.println("111");
    }
    //通过再方法上标识 ACC_SYNCHRONIZED 来表明这是一个同步方法
    // flags: ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
    public static synchronized  void test2(){
        System.out.println("1111");
    }
    public static void main(String[] args) {

    }
}

/**

 {
 final java.lang.Object obj;
 descriptor: Ljava/lang/Object;
 flags: ACC_FINAL

 public cn.ly.manyThread.threadSafe.SynchronizedMointerTest();
 descriptor: ()V
 flags: ACC_PUBLIC
 Code:
 stack=3, locals=1, args_size=1
 0: aload_0
 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 4: aload_0
 5: new           #2                  // class java/lang/Object
 8: dup
 9: invokespecial #1                  // Method java/lang/Object."<init>":()V
 12: putfield      #3                  // Field obj:Ljava/lang/Object;
 15: return
 LineNumberTable:
 line 3: 0
 line 4: 4
 LocalVariableTable:
 Start  Length  Slot  Name   Signature
 0      16     0  this   Lcn/ly/manyThread/threadSafe/SynchronizedMointerTest;

 public void c1();
 descriptor: ()V
 flags: ACC_PUBLIC
 Code:
 stack=2, locals=3, args_size=1
 0: aload_0
 1: getfield      #3                  // Field obj:Ljava/lang/Object;
 4: dup
 5: astore_1
 6: monitorenter
 7: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
 10: ldc           #5                  // String aaa
 12: invokevirtual #6                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 15: aload_1
 16: monitorexit
 17: goto          25
 20: astore_2
 21: aload_1
 22: monitorexit
 23: aload_2
 24: athrow
 25: return
 Exception table:
 from    to  target type
 7    17    20   any
 20    23    20   any
 LineNumberTable:
 line 7: 0
 line 8: 7
 line 9: 15
 line 10: 25
 LocalVariableTable:
 Start  Length  Slot  Name   Signature
 0      26     0  this   Lcn/ly/manyThread/threadSafe/SynchronizedMointerTest;
 StackMapTable: number_of_entries = 2
 frame_type = 255
          offset_delta = 20
                  locals = [ class cn/ly/manyThread/threadSafe/SynchronizedMointerTest, class java/lang/Object ]
        stack = [ class java/lang/Throwable ]
        frame_type = 250
        offset_delta = 4

public synchronized void test();
        descriptor: ()V
        flags: ACC_PUBLIC, ACC_SYNCHRONIZED
        Code:
        stack=2, locals=1, args_size=1
        0: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
        3: ldc           #7                  // String 111
        5: invokevirtual #6                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        8: return
        LineNumberTable:
        line 13: 0
        line 14: 8
        LocalVariableTable:
        Start  Length  Slot  Name   Signature
        0       9     0  this   Lcn/ly/manyThread/threadSafe/SynchronizedMointerTest;

public static synchronized void test2();
        descriptor: ()V
        flags: ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
        Code:
        stack=2, locals=0, args_size=0
        0: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
        3: ldc           #8                  // String 1111
        5: invokevirtual #6                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        8: return
        LineNumberTable:
        line 17: 0
        line 18: 8

public static void main(java.lang.String[]);
        descriptor: ([Ljava/lang/String;)V
        flags: ACC_PUBLIC, ACC_STATIC
        Code:
        stack=0, locals=1, args_size=1
        0: return
        LineNumberTable:
        line 21: 0
        LocalVariableTable:
        Start  Length  Slot  Name   Signature
        0       1     0  args   [Ljava/lang/String;
        }
        SourceFile: "SynchronizedMointerTest.java"


 **/
