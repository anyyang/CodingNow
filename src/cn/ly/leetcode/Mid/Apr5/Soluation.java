package cn.ly.leetcode.Mid.Apr5;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        if (nums == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int m = 0;
        int n = nums.length - 1;
        int left = nums[m];
        int right = nums[n];
        list.add(right);
        while (m < n) {
            if (left < right) {
                ++m;
                left += nums[m];
            } else if (left >= right) {
                --n;
                right += nums[n];
                list.add(nums[n]);
            }

        }

        return list;
    }

    int count = 0;
    public int numSteps(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        long i =  Math.abs(Long.parseUnsignedLong(s, 2));

        int m = getAnswer(i);
        return count;

    }

    public int getAnswer(long a) {

        if (a == 0) {
            return 0;
        }else if (a==1) {
            return 1;
        }
        else if (a % 2 == 0) {
            count++;
            return getAnswer(a/2);
        } else if (a % 2 == 1) {
            count++;
            return getAnswer(a+1);
        }
        return getAnswer(a);
    }



  /**  public int numSteps(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] arrs = s.toCharArray();
        for(int i=0;i<arrs.length;i++){
            if()
        }
        return count;

    }
    **/

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println( so.numSteps("1111110011101010110011100100101110010100101110111010111110110010"));


    }
}