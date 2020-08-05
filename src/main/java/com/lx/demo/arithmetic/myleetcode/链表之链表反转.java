package com.lx.demo.arithmetic.myleetcode;

import com.lx.demo.arithmetic.common.ListNode;
import com.lx.demo.arithmetic.link.ReverseLink;

public class 链表之链表反转 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode newNode = reverseGroup(head,2);
        while (newNode != null) {
            System.out.print(newNode.val + " ");
            newNode = newNode.next;
        }

    }

    /**
     * 递归实现
     * @param head
     */
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head.next;
        ListNode newNode = reverse(head.next);

        temp.next = head;
        head.next = null;

        return newNode;
    }

    /**
     * 非递归实现
     * @param head
     */
    public static ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;

        return pre;

    }

    /**
     * k组反转
     * @param head
     */
    public static ListNode reverseGroup(ListNode head,int k) {
        ListNode temp = head;

        for (int i = 1; i < k && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            return head;
        }

        ListNode l2 = temp.next;

        temp.next = null;
        ListNode newHead = reverse2(head);
        ListNode newTemp = reverseGroup(l2,k);
        head.next = newTemp;

        return newHead;
    }



}
