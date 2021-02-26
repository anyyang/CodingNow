package cn.ly.leetcode.Mid;

import cn.ly.leetcode.Mid.Apr1.Solution;

public class Common {
    /**
     * @return  返回长度为6的链表
     */
    public static ListNode getListNode(){
        int i=2;
        ListNode node =new ListNode(1);
        while (i<6){
            i++;
            ListNode flag= node;
            while(flag.next!=null)
                flag=flag.next;

            flag.next=new ListNode(i);
        }
        return  node;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}