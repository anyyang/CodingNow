package cn.ly.leetcode.Mid.Apr12;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class queriesoapermutationwithkey {

    public int[] processQueries(int[] queries, int m) {
        if (queries == null || m == 0) {
            return null;
        }
        int[] result = new int[queries.length];
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>(m, 0.75f, true);
        for (int i = m; i > 0; i--) {
            linkedHashMap.put(i, i);
        }
        for(int j=0 ;j <queries.length; j++){
            int findindex = findindex(linkedHashMap, queries[j]);
            System.out.println(findindex);
            linkedHashMap.get( queries[j]);
           // iterator(linkedHashMap);
            result[j]=findindex;
        }

        return result;
    }


    public int findindex(LinkedHashMap<Integer, Integer> map, int value) {
        Iterator<Map.Entry<Integer, Integer>> iterable = map.entrySet().iterator();
        int count = 1;
        while (iterable.hasNext()) {
            Map.Entry<Integer, Integer> next = iterable.next();
            if (next.getKey() == value) {
              break;
            }
            count++;
        }
        return  map.size()-count;
    }

    public static void iterator(LinkedHashMap<Integer, Integer> map) {
        Iterator<Map.Entry<Integer, Integer>> iterable = map.entrySet().iterator();
        while (iterable.hasNext()) {
            Map.Entry<Integer, Integer> next = iterable.next();
           // System.out.println("key" + next.getKey() + " value" + next.getValue());
        }
    }


    public static void main(String[] args) {
        queriesoapermutationwithkey key = new queriesoapermutationwithkey();
        key.processQueries(new int[]{3,1,2,1}, 5);
    }
}

