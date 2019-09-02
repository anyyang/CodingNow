package cn.ly.leetcode.Mid.Sep1;

public class Solution2 {

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int result = 0;
        //处理特殊情况  k小于数组长度的
        if (k >= calories.length) {
            int sum = 0;
            for (int i = 0; i < calories.length; i++) {
                sum += calories[i];
            }
            if (sum < lower) {
                result -= 1;
            } else if (sum > upper) {
                result += 1;
            }
            return result;
        } else if (k == 1) {
            for (int i = 0; i < calories.length; i++) {
                if (calories[i] < lower) {
                    result -= 1;
                } else if (calories[i] > upper) {
                    result += 1;
                }
            }
            return result;
        }

        for (int i = 0; i < calories.length; i += k) {
            if (i > calories.length - 1) {
                break; //越界了扔掉
            }
            int sum = 0;
            for (int j = i; j < (i + k); j++) {
                if(j<calories.length){
                    sum += calories[j];
                }else {
                    continue;
                }
            }
            if (sum < lower) {
                result -= 1;
            } else if (sum > upper) {
                result += 1;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        //[6,13,8,7,10,1,12,11]
        //6
        //5
        //37
        int[] calories = new int[]{6,13,8,7,10,1,12,11};

        int k = 6, lower = 5, upper = 37;
        Solution2 so = new Solution2();
        int reuslt = so.dietPlanPerformance(calories, k, lower, upper);
        System.out.println(reuslt);
    }
}
