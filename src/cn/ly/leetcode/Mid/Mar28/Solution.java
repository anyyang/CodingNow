package cn.ly.leetcode.Mid.Mar28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    public int minimumLengthEncoding2(String[] words) {
        if (words == null) {
            return 0;
        }
        if (words.length < 2) {
            return words.length + 1;
        }
        HashSet<String> set= new HashSet<String>(Arrays.asList(words));
        for(String s:words){
           char[] chars = s.toCharArray();
           String temp = "";
            for(int i=0;i<chars.length-1;i++){
               temp=chars[chars.length-1-i]+temp;
                set.remove(temp);
            }
        }
        String result = "";
        for (String s: set){
            result = result+ s + "#";
        }
        System.out.println(result);
        return result.length();

    }
    public int minimumLengthEncoding(String[] words) {
        String result = "";

        String[] arrays = words;
        for (int i = 0; i < arrays.length; i++) {
            for(int j=0;j<arrays.length;j++){
                if(i==j){
                    continue;
                }else{
                    if(arrays[i].endsWith(arrays[j])){
                       arrays[j]="";
                    }
                }

            }

        }
        for(int k=0;k<arrays.length;k++){
            if(!"".equals(arrays[k])){
                result=result+arrays[k]+"#";
            }
        }
        System.out.println(result);
        return result.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] str=new String[]{"time", "me", "bell"};
        int result = solution.minimumLengthEncoding2(str);
        System.out.println(result);
    }
}
