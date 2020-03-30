package cn.ly.leetcode.Mid.Mar30;

class Solution {
    public void reverseString(char[] s) {
        revser(0,s);
    }
    public void revser(int start, char[] s){
        if(start>=s.length/2 ||s ==null){
            return ;
        }
        char temp = s[start];
        s[start]  = s[s.length-start-1];
        s[s.length-start-1]  = temp;
        revser(start+1,s);
    }

    public static void main(String[] args) {
        Solution solution =new Solution();
        char[] s={'a','b','c','d','e','f','g','h'};
        solution.reverseString(s);
        System.out.println(s);
    }
}