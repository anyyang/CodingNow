package cn.ly.leetcode.Mid.Sep25;

public class Solution {
    public String reverseWords(String s) {
        String[] array = s.split(" ");
        String result = "";
        for (int i = array.length - 1; i >= 0; i--) {
            result = (result + " " + array[i]).trim();
        }
        return null;
    }
    public static void main(String args[]){
        Solution  so = new Solution();
        String re= so.reverseWords("liuyang hello world!  ");
        System.out.println(re);
    }
}
