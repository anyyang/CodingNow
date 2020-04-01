package cn.ly.leetcode.Mid.Apr1;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
        return reverse(head).next;//去除头
    }
    public ListNode  reverse(ListNode head){
        if(head == null){
            return new ListNode(-1);
        }
        ListNode newHeadnode =  reverse(head.next);
        ListNode flag = newHeadnode;
        while(flag.next!=null){
            flag=flag.next;
        }
        flag.next = head;
        return newHeadnode;
    }

    public static void main(String[] args) {

    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }