package cn.ly.leetcode.Mid.Apr9;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/generate-parentheses
// 基于DFS深度遍历的 穷举
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n == 0) {
            result.add("");
            return result;
        }
        if (n == 1) {
            result.add("()");
            return result;
        }
        getkuohao(n, n, "", result);
        return result;
    }

    public void getkuohao(int left, int right, String cur, List<String> result) {
        if(right==0 && left!=0){
            return;
        }

        if(right==0 && left!=0){
            return;
        }
        if (left == 0 && right == 0) {
          //  System.out.println(cur);
            result.add(cur);
            return;
        }
        if (left > 0) { //左边括号直接用完了。
            getkuohao(left - 1, right, cur + "(", result);
        }
        if (right > left) {//右边还有括号
            getkuohao(left, right - 1, cur + ")", result);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateParenthesis(3);
    }
}
