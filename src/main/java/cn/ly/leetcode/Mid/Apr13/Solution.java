package cn.ly.leetcode.Mid.Apr13;


import cn.ly.leetcode.Mid.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = maxDepth(root.left)+1;
        int right=maxDepth(root.right)+1;
        return  Math.max(left,right);
    }
}
