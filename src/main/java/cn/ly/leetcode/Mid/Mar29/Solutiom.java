package cn.ly.leetcode.Mid.Mar29;

import java.util.Arrays;

class Solution {
    public int findLucky(int[] arr) {
        if(arr==null){
            return -1;
        }
        int[] temp=new int[arr.length+1];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>arr.length){
                continue;
            }
            temp[arr[i]]++;
        }
        int result =-1;

        for(int j=0;j<temp.length ; j++){
            if(temp[j]==j){
               result= Math.max(temp[j],result);
            }
        }
        if(result==0){
            return -1;
        }
         return result;
    }

    public static void main(String[] args) {
        int[] i ={2,2,3,4};
        Solution so = new Solution();
        int j = so.findLucky(i);
        System.out.println(j);
    }
    public int numTeams(int[] rating) {
        int result = 0;
        for(int i=0 ;i<rating.length-2; i++){
            for(int j =i+1 ;j<rating.length-1;j++){
                if(rating[j]>rating[i]){
                    for(int k=j+1;k<rating.length; k++){
                        if(rating[k]>rating[j]){
                            result++;
                        }
                    }
                }else if(rating[j]<rating[i]){
                    for(int k=j+1;k<rating.length; k++){
                        if(rating[k]<rating[j]){
                            result++;
                        }
                    }
                }

            }
        }
        return result;
    }
}