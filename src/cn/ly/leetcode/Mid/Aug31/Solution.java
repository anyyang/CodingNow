package cn.ly.leetcode.Mid.Aug31;

import java.util.Arrays;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * https://leetcode-cn.com/problems/add-two-numbers/solution/
 * }
 */
/*给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 
        的方式存储的，并且它们的每个节点只能存储 一位 数字。
        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
        示例：
        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
        输出：7 -> 0 -> 8
        原因：342 + 465 = 807
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/add-two-numbers
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

        思路：问题关键如果是数字太大的怎么办，不能简单使用java类型表示出来的数很容易溢出
         所以 使用遍历
        */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> result = new Stack<Integer>();
        //保存进位标记
        int temp = 0;
        while (l1 != null || l2 != null || temp != 0) {
            if (l1 != null && l2 != null) {
                int sum = l1.val + l2.val + temp;
                if (sum < 10) {
                    //没有溢出位
                    result.push(sum);
                    //temp 归零
                    temp = 0;
                } else {
                    //大于10 的时候 取模运算，把余数放入到栈中
                    result.push(sum % 10);
                    //标记temp为1  有溢出位
                    temp = 1;
                }
                l1 = l1.next;
                l2 = l2.next;
                if (l1 == null && l2 == null && temp == 1) {
                    result.push(1);
                    temp = 0;
                }
            } else if (l1 != null && l2 == null) {
                //l2 长度不够
                int sum = l1.val + temp;
                if (sum < 10) {
                    //没有溢出位
                    result.push(sum);
                    //temp 归零
                    temp = 0;
                } else {
                    //大于10 的时候 取模运算，把余数放入到栈中
                    result.push(sum % 10);
                    //标记temp为1  有溢出位
                    temp = 1;
                }
                l1 = l1.next;
                if (l1 == null && temp == 1) {
                    result.push(1);
                    temp = 0;
                }

            } else if (l2 != null && l1 == null) {
                //l1 长度不够
                //l2 长度不够
                int sum = l2.val + temp;
                if (sum < 10) {
                    //没有溢出位
                    result.push(sum);
                    //temp 归零
                    temp = 0;
                } else {
                    //大于10 的时候 取模运算，把余数放入到栈中
                    result.push(sum % 10);
                    //标记temp为1  有溢出位
                    temp = 1;
                }
                l2 = l2.next;
                if (l2 == null && temp == 1) {
                    result.push(1);
                    temp = 0;
                }
            }
        }
        ListNode headNode =null;
        ListNode flag = null;
        while(!result.empty()){
           Integer m = result.pop();
           if(headNode == null){
               headNode = new ListNode(m);
               flag =headNode;
           }else{
               headNode = new ListNode(m);
               headNode.next = flag;
               flag = headNode;
           }
        }
        return headNode;
    }

    public static void main(String args[]) {
        Solution so = new Solution();
        ListNode node = getTest1(so);
        // ListNode node = getTest3(so);
        printNodeList(node);

    }


    private static ListNode getTest3(Solution so) {
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


    private static ListNode getTest1(Solution so) {
        ListNode a1 = new ListNode(9);
        ListNode a2 = new ListNode(9);
        ListNode a3 = new ListNode(9);
        a1.next = a2;
        a2.next = a3;
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(1);
        // ListNode b3 = new ListNode(1);
        b1.next = b2;
        //b2.next = b3;

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