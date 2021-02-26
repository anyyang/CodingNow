package cn.ly.leetcode.Mid.Sep22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/contest/weekly-contest-155/problems/minimum-absolute-difference/
 * 给你个整数数组 arr，其中每个元素都 不相同。

 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 示例 1：
 输入：arr = [4,2,1,3]
 输出：[[1,2],[2,3],[3,4]]
 示例 2：

 输入：arr = [1,3,6,10,15]
 输出：[[1,3]]
 示例 3：

 输入：arr = [3,8,-10,23,19,-4,-14,27]
 输出：[[-14,-10],[19,23],[23,27]]
 */
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
