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
        flag.next = new ListNode(head.val);
        return newHeadnode;
    }

    public static void main(String[] args) {
        Solution s2 = new Solution();
        int i=2;
        ListNode node =new ListNode(1);
        while (i<6){
            ListNode flag= node;
            while(flag.next!=null){
                flag=flag.next;
            }
            flag.next=new ListNode(i);
            i++;
        }
       ListNode result= s2.reverse(node);
        System.out.println(result);
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

}