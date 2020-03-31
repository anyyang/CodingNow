package cn.ly.leetcode.Mid.Mar31;

import java.util.Arrays;

class Solution {
    public int[] sortArray(int[] nums) {
        if(nums==null || nums.length == 1)
        {
            return nums;
        }
        return maopap(nums);

    }
    public int[] maopap(int[] nums){
        for(int i=0; i<nums.length; i++){
            boolean isswap=false;
            for( int j=0;j<nums.length-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                    isswap=true;
                }
            }
            if(!isswap){
                break;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
       Solution  s2= new Solution();
        int[]  nums = {4,2,0,1,5,6,3,7};
        nums=s2.maopap(nums);
        Arrays.stream(nums).forEach(i-> System.out.print(" "+i));
    }
}