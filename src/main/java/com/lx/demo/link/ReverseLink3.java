package com.lx.demo.link;

public class ReverseLink3 {
    public static void main(String[] args) {
        ReverseLink2.ListNode head = new ReverseLink2.ListNode(1);
        ReverseLink2.ListNode node2 = new ReverseLink2.ListNode(2);
        ReverseLink2.ListNode node3 = new ReverseLink2.ListNode(3);
        ReverseLink2.ListNode node4 = new ReverseLink2.ListNode(3);
        ReverseLink2.ListNode node5 = new ReverseLink2.ListNode(5);
        ReverseLink2.ListNode node6 = new ReverseLink2.ListNode(5);
        ReverseLink2.ListNode node7 = new ReverseLink2.ListNode(7);
        ReverseLink2.ListNode node8 = new ReverseLink2.ListNode(8);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

//        ReverseLink2.ListNode newNode = reverseKGroup(head,3);
        ReverseLink2.ListNode newNode = deleteNode(head);

        while (newNode != null) {
            ReverseLink2.ListNode node = newNode.next;
            System.out.print(newNode.data);
            System.out.print(" ");
            newNode = node;
        }
    }

//    //逆序单链表
//    private static ReverseLink2.ListNode reverseList3(ReverseLink2.ListNode head) {
//        if (head == null && head.next == null) {
//            return head;
//        }
//        ReverseLink2.ListNode newNode = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return newNode;
//    }
    //逆序单链表
    private static ReverseLink2.ListNode reverseList(ReverseLink2.ListNode head) {
        if(head == null || head.next == null)
            return head;
        ReverseLink2.ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }
    public static ReverseLink2.ListNode solve(ReverseLink2.ListNode head, int k) {
        // 调用逆序函数
        head = reverseList(head);
        // 调用每 k 个为一组的逆序函数（从头部开始组起）
        head = reverseKGroup(head, k);
        // 在逆序一次
        head = reverseList(head);
        return head;

    }


    //逆序单链表
    private static ReverseLink2.ListNode reverseKGroup(ReverseLink2.ListNode head, int k) {

        ReverseLink2.ListNode temp = head;
        for (int i = 1; i < k && temp != null; i++) {
            temp = temp.next;
        }
        //判断节点的数量是否能够凑成一组
        if(temp == null)
            return head;

        ReverseLink2.ListNode t2 = temp.next;
        temp.next = null;
        ReverseLink2.ListNode newHead = reverseList(head);
        ReverseLink2.ListNode newTemp = reverseKGroup(t2,k);
        head.next = newTemp;
        return newHead;
    }

    /**
     * 删除有序链表中的重复元素
     */
    public static ReverseLink2.ListNode deleteNode(ReverseLink2.ListNode head) {
        if (head == null && head.next == null) {
            return head;
        }

        ReverseLink2.ListNode newN = new ReverseLink2.ListNode(-1);
        ReverseLink2.ListNode pre = newN;

        while (head != null) {
            ReverseLink2.ListNode next = head.next;
            if (next != null && head.data == next.data) {
                int val = next.data;
                while (head != null && head.data == val) {
                    head = head.next;
                }

            } else {
                pre.next = head;
                pre = pre.next;
                head = next;
            }
        }
        pre.next = null;

        return newN.next;
    }
}


