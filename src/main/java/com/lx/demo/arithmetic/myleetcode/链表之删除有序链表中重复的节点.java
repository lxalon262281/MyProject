package com.lx.demo.arithmetic.myleetcode;

import com.lx.demo.arithmetic.common.ListNode;

public class 链表之删除有序链表中重复的节点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode newNode = delete2(head);
        while (newNode != null) {
            System.out.print(newNode.val + " ");
            newNode = newNode.next;
        }
    }

    /**
     * 删除重复节点，重复的节点保留
     * @param head
     */
    public static ListNode delete1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        while (node != null) {
            while (node.next != null && node.val == node.next.val) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        return head;
    }

    /**
     * 删除重复节点，重复的节点保留
     * @param head
     */
    public static ListNode delete2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newNode = new ListNode(-1);
        ListNode pre = newNode;
        ListNode node = head;
        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                int num = node.val;
                while (node != null && node.next.val == num) {
                    node = node.next;
                }
            } else {
                pre.next = node;
                pre = node;
                node = node.next;
            }
            }

        head.next = null;

        return newNode.next;
    }

    /**
     * 删除重复节点，重复的节不点保留
     * @param head
     */
    public static ListNode delete3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newNode = new ListNode(-1);
        ListNode pre = newNode;
        ListNode node = head;
        System.out.print("");
        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                int num = node.val;
                while (node != null && node.val == num) {
                    node = node.next;
                }
            } else {
                pre.next = node;
                pre = node;
                node = node.next;
            }

        }
        pre.next = null;

        return newNode.next;
    }
}
