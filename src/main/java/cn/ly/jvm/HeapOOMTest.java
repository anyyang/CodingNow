package cn.ly.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆 的OOM
 */
public class HeapOOMTest {

    public static void main(String[] args) {
        List<HeapOOMTest> list = new ArrayList<HeapOOMTest>();

        while (true) {
            list.add(new HeapOOMTest());
        }
    }
}
