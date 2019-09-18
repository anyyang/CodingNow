package cn.ly.leetcode.Mid.Sep18;

import java.util.Arrays;

/**
 * Created by  liuyang
 * 2019/9/17    14:14
 * cn.ly.leetcode.Mid.Sep17
 * All Right Reserved by liuyang.
 **/

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            max = Math.max(max, temp);
            for (int j = i + 1; j < nums.length; j++) {
                temp += nums[j];
                max = Math.max(max, temp);
            }

        }
        return max;
    }

    /**
     * 分治法解决问题
     * @param nums
     * @return
     */
    public int maxSubArrayOne(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String args[]) {
        int[] temp = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution so = new Solution();

        System.out.println(so.maxSubArrayOne(temp));
      /*
        int result = so.maxSubArray(temp);
        System.out.println(result);
        */
    }

}
