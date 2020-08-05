package com.lx.demo.arithmetic.link;

public class ReverseLink2 {
    static class ListNode {
        public int data;
        public ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }
    //k个为一组逆序
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        for (int i = 1; i < k && temp != null; i++) {
            temp = temp.next;
        }
        //判断节点的数量是否能够凑成一组
        if(temp == null)
            return head;

        ListNode t2 = temp.next;
        temp.next = null;
        //把当前的组进行逆序
        ListNode newHead = reverseList(head);
        //把之后的节点进行分组逆序
        ListNode newTemp = reverseKGroup(t2, k);
        // 把两部分连接起来
        head.next = newTemp;

        return newHead;
    }

    //逆序单链表
    private static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }
    public static ListNode solve(ListNode head, int k) {
        // 调用逆序函数
        head = reverseList(head);
        // 调用每 k 个为一组的逆序函数（从头部开始组起）
        head = reverseKGroup(head, k);
        // 在逆序一次
        head = reverseList(head);
        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);
//        ListNode node7 = new ListNode(7);
//        ListNode node8 = new ListNode(8);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node6;
//        node6.next = null;

//        ListNode newNode = reverseKGroup(head,3);
        ListNode newNode = deleteNode(head);
        while (newNode != null) {
            ListNode node = newNode.next;
            System.out.print(newNode.data);
            System.out.print(" ");
            newNode = node;
        }
    }

    /**
     * 删除有序链表中的重复元素
     */
    public static ListNode deleteNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newNode = new ListNode(-1);
        ListNode pre = newNode;
        ListNode cur = head;

        while (cur != null) {
            if (cur.next != null && cur.data == cur.next.data) {
                int val =  cur.data;

                while (cur != null && cur.data == val) {
                    cur = cur.next;
                }
            } else {
                pre.next = cur;
                pre = pre.next;
                cur = cur.next;
            }
        }

        pre.next = null;
        return newNode.next;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newNode = new ListNode(-1);
        ListNode pre = newNode;
        ListNode cur = head;


        while(cur != null) {
            if(cur.next != null && cur.data == cur.next.data) {
                pre.next = cur.next;
                pre = cur.next;
                int data = cur.data;
                while(cur != null && cur.data == data ) {
                    cur = cur.next;
                }
            }
            pre.next = cur;
            pre = cur;
            if (cur != null && cur.next != null) {
                cur = cur.next;
            }
        }

        return newNode.next;
    }
}
