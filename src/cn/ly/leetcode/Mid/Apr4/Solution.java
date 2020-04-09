package cn.ly.leetcode.Mid.Apr4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countLargestGroup(int n) {
        Map<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        int maxlength=0;
        int count = 0;
        if(n < 10){
            return n;
        }
        for(int i=1;i<n+1;i++){
            int x=i;
            int sum =0;
            while(x!=0){
                int temp =x%10;
                sum+=temp;
                x=(x-temp)/10;
            }
            ArrayList<Integer> arrays = map.get(sum);
            if(arrays==null){
                arrays = new ArrayList<Integer>();
                arrays.add(i);
                map.put(sum,arrays);
            }else{
                arrays.add(i);
            }

            if(arrays.size()>maxlength){
                maxlength = arrays.size();
                count=1;
            }else if(arrays.size()==maxlength){

                count+=1;

            }
        }
        return count;

    }

    public static void main(String[] args) {
        Solution so = new Solution() ;
        so.countLargestGroup(10000);
    }
}