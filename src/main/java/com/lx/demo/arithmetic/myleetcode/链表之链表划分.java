package com.lx.demo.arithmetic.myleetcode;

import com.lx.demo.arithmetic.common.ListNode;
import com.sun.org.apache.regexp.internal.RE;

/**
 * 给出一个链表和一个值x，以x为参照将链表划分成两部分，使所有小于x的节点都位于大于或等于x的节点之前。
 两个部分之内的节点之间要保持的原始相对顺序。
 例如：
 给出1->4->3->2->5->2和x = 3,
 返回1->2->2->4->3->5.
 */
public class 链表之链表划分 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode node = partition(head,3);

        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

    }

    public static ListNode partition(ListNode head, int target) {
        ListNode lowHead = new ListNode(-1);
        ListNode highHead = new ListNode(-1);

        ListNode low = lowHead,high = highHead,node = head;

        while (node != null) {
            ListNode next = node.next;
            if (node.val < target) {
                low.next = node;
                low = low.next;
                low.next = null;
            } else {
                high.next = node;
                high = high.next;
                high.next = null;
            }
            node = next;
        }

        low.next = highHead.next;
        return lowHead.next;
    }
}
