package cn.ly.leetcode.Mid.Mar26;

import cn.ly.leetcode.Mid.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Codec {


    public String serialize(TreeNode root) {
        if(root==null){
            return "null";
        }
        String s=String.valueOf(root.val);
        String a = serialize(root.left);
        String b = serialize(root.right);
       return  s+","+a+","+b;
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }


    public static void main(String args[]) {
        TreeNode node = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node.left = node1;
        node.right = node2;
        node2.left = node3;
        node2.right = node4;
        node4.left = node5;
        Codec seri = new Codec();
        String str = seri.serialize(node);
        System.out.println(str);
    }
}
