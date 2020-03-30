package cn.ly.leetcode.Mid.Mar30;


public class Solution2 {

    public ListNode swapPairs(ListNode head) {
        swap(head);
        return head;
    }

    ListNode swap(ListNode head) {
        if (head == null ) {
            return null ;
        }
        if(head.next==null){
            return head;
        }
        ListNode temp = head.next;
        head.next = temp.next;
        temp.next = head;
        head=temp;
        head.next.next = swap(head.next.next);
        return head;
    }

    public static void main(String[] args) {
        Solution2 s2= new Solution2();
        ListNode header = new ListNode(1);
        for (int i = 2; i < 10; i++) {
            appendNode( header,new ListNode(i));
        }

        header.print( header);
        s2.swapPairs( header);
        System.out.println();
        header.print( header);
    }

    public static void appendNode(ListNode head, ListNode append) {

        if (head.next != null) {
            appendNode(head.next, append);
        }
        if (head.next == null) {
            head.next = append;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void print(ListNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        print(node.next);
    }

}
