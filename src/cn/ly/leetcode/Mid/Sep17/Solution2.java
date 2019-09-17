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
        String middle = "";
        boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
          if (chars[i] == ')') {

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
//
    }


    /*** 别人的递归思路
     */
    int idx = 0;
    public String reverseParentheses2(String s) {
        char[] sa = s.toCharArray();
        return dfs(sa).toString();
    }
    public StringBuilder dfs(char[] sa) {
        StringBuilder ans = new StringBuilder();
        // 处理当前遇到的未在括号内的字符
        while (idx < sa.length && sa[idx] != '(' && sa[idx] != ')') {
            ans.append(sa[idx]);
            idx++;
        }
        // 位置变量到终点，返回结果
        if (idx == sa.length) {
            return ans;
            // 右括号代表处理结束，位置变量加一，移动到下一个递归处理的位置
        } else if (sa[idx] == ')') {
            idx++;
            return ans;
            // 左括号代表当前遇到一个需要处理的括号，位置变量加一，移动下一个递归处理的位置
        } else {
            idx++;
            // dfs(sa) 进入下一层递归，处理括号内的内容
            StringBuilder cur = dfs(sa);
            // 递归完这个括号，后面可能还有剩余字符，进入下一个递归
            StringBuilder next = dfs(sa);
            // 将之前递归处理好的内容进行反转，并拼接下一个递归的结果
            // 因为知道当前处理的内容是在括号中，需要翻转；
            // 而后面的字符不一定是在括号中，并且我们也不需要去考虑，可以当做新的字符串丢入递归进行处理
            ans.append(cur.reverse().toString()).append(next.toString());
            return ans;
        }
    }


}
