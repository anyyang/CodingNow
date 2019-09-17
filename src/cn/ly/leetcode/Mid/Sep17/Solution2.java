package cn.ly.leetcode.Mid.Sep17;

import java.util.Stack;

/**
 * Created by  liuyang
 * 2019/9/17    14:31
 * cn.ly.leetcode.Mid.Sep17
 * All Right Reserved by liuyang.
 **/

public class Solution2 {
    public String reverseParentheses(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> s1 = new Stack<Character>();
        Stack<Character> s2 = new Stack<Character>();
        boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                continue;
            } else if (chars[i] == ')') {
                if (flag) {
                    flag = false;
                    s2 = s1;
                    s1 = new Stack<Character>();
                }
                continue;
            }
            s1.push(chars[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!s1.isEmpty()) {
            sb.append(s1.pop());
        }
        while (!s2.isEmpty()) {
            sb.append(s2.pop());
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        Solution2 s2 = new Solution2();
        String result = s2.reverseParentheses( "(ed(et(oc))el)");
        System.out.println(result);

    }
}
