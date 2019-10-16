package com.lx.link;

public class LinkSort {
    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int data) {
            this.val = data;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {
        quicksort(head,null);
        return head;
    }

    public ListNode partition(ListNode head,ListNode end){
        ListNode slow = head;
        ListNode fast = end;
        while(fast != end){
            if(fast.val < end.val){
                slow = slow.next;
                slow.val = fast.val ^ slow.val ^ (fast.val = slow.val);//exchange slow.val and fast.val
            }
            fast = fast.next;
        }
        slow.val = head.val ^ slow.val ^ (head.val = slow.val);
        return slow;
    }

    public void quicksort(ListNode head,ListNode end){
        ListNode mid = partition(head,end);
        quicksort(head,mid);
        quicksort(mid.next,end);
    }
}
