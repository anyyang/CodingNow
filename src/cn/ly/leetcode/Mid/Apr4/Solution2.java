package cn.ly.leetcode.Mid.Apr4;

public class Solution2 {

    public boolean canConstruct(String s, int k) {
        if (s == null || "".equals(s) || k < 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        if (k > chars.length / 2) {
            return false;
        }
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            sb.append("#");
        }
        chars=sb.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i-k<0||i+k+1>chars.length){
                continue;
            }
            String left =sb.substring(i-k,i);
            String right=sb.substring(i+1,i+k+1);
            if(left.equals(right)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution2 s2=new Solution2();
        s2.canConstruct("allennne",2);
    }
}