package cn.ly.leetcode.Mid.Apr12;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>(6, 0.75f, true);
        map.put("a", 4);
        map.put("b", 3);
        map.put("c", 2);
        map.put("d", 1);
        map.get("c");
        //map.get("b");
        iterator(map);
    }
    public static void iterator(LinkedHashMap<String,Integer> map){
        Iterator<Map.Entry<String,Integer>> iterable = map.entrySet().iterator();
        while(iterable.hasNext()){
            Map.Entry<String,Integer> next = iterable.next();
            System.out.println("key"+next.getKey()+" value"+next.getValue());
        }
    }
}
