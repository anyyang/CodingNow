package cn.ly.leetcode.Mid.Sep22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solutaion {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i] - arr[i - 1];
            temp = Math.abs(temp);
            if(temp>min){
                continue;
            }
            if (temp < min) {
                min=temp;
                result.clear();
            }
            List<Integer> templist = new ArrayList<>();
            templist.add(arr[i - 1]);
            templist.add(arr[i]);
            result.add(templist);

        }
        return result;
    }
    public static void main(String args[]){
      int x[] = new int[]{5,4,3,2,1};
      Solutaion  so = new Solutaion();
      so.minimumAbsDifference(x);
    }
}
