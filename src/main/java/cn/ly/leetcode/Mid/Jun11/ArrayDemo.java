package cn.ly.leetcode.Mid.Jun11;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 * 4. 寻找两个正序数组的中位数
 *给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class ArrayDemo {

    public static void main(String[] args) {
        Solution.findMedianSortedArrays(new int[]{1,2},new int[]{3,4});
    }
}

class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] dd = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, dd, 0, nums1.length);
        System.arraycopy(nums2, 0, dd, nums1.length, nums2.length);
        Arrays.sort(dd);
        if(dd.length%2==0){
            int index = dd.length /2-1 ;
            int next = index +1;
            double result  =((double)dd[index]+(double)dd[next])/2;
            return  result;
        }else {
            int index = dd.length /2 ;
            return   dd[index];
        }
    }
}
