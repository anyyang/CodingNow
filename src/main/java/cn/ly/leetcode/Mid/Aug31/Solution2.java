package cn.ly.leetcode.Mid.Aug31;

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long count = 1;
        long a = 0;
        long b = 0;
        do {
            if (l1 != null) {
                a = a + l1.val * count;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = b + l2.val * count;
                l2 = l2.next;
            }
            count = 10 * count;
        } while (l1 != null | l2 != null);
        long c = a + b;
        boolean fuhaowei = true;
        if (c < 0) {
            fuhaowei = false;
            c = 0 - c;
        }
        char[] strc = String.valueOf(c).toCharArray();
        Arrays.toString(strc);
        ListNode headerNode = null;
        ListNode pointNode = null;
        for (int i = 1; i <= strc.length; i++) {
            if (headerNode == null) {
                headerNode = new ListNode(Integer.valueOf(("" + strc[strc.length - i])));
                pointNode = headerNode;
            } else {
                pointNode.next = new ListNode(Integer.valueOf(("" + strc[strc.length - i])));
                pointNode = pointNode.next;
            }
        }

        return headerNode;
    }

    public static void main(String args[]) {
        Solution2 so = new Solution2();
        // ListNode node = getTest1(so);
        ListNode node = getTest3(so);
        printNodeList(node);

    }


    private static ListNode getTest3(Solution2 so) {
        ListNode a1 = new ListNode(9);

        ListNode b1 = new ListNode(9);
        ListNode b2 = new ListNode(9);
        ListNode b3 = new ListNode(9);
        ListNode b4 = new ListNode(9);
        ListNode b5 = new ListNode(9);
        ListNode b6 = new ListNode(9);
        ListNode b7 = new ListNode(9);
        ListNode b8 = new ListNode(9);
        ListNode b9 = new ListNode(9);
        ListNode b10 = new ListNode(9);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;
        b5.next = b6;
        b6.next = b7;
        b7.next = b8;
        b8.next = b9;
        b9.next = b10;
        return so.addTwoNumbers(a1, b1);
    }


    private static ListNode getTest1(Solution2 so) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(9);
        ListNode a3 = new ListNode(9);
        a1.next = a2;
        a2.next = a3;
        ListNode b1 = new ListNode(9);
        ListNode b2 = new ListNode(9);
        ListNode b3 = new ListNode(9);
        b1.next = b2;
        b2.next = b3;

        return so.addTwoNumbers(a1, b1);
    }

    private static void printNodeList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}