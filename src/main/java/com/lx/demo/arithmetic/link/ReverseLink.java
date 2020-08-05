package com.lx.demo.arithmetic.link;

public class ReverseLink {

    static class Node {
        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node newNode = reverseList4(head);
        while (newNode != null) {
            Node node = newNode.next;
            System.out.print(newNode.data);
            System.out.print(" ");
            newNode = node;
        }
//        Node newNode = new Node(-1);
//        if (head == null) {
//            head = newNode;
//        }
//        Node temp = head;
//        while (temp != null) {
//            if (temp.data == 4) {
//                Node t2 = temp.next;
//                newNode.next = t2;
//                temp.next = newNode;
//            }
//            temp = temp.next;
//        }
//
//        while (head != null) {
//            Node node = head.next;
//            System.out.print(head.data);
//            System.out.print(" ");
//            head = node;
//        }

    }
    public static Node reverseList2(Node head) {
        if (head != null && head.next == null) {
            return head;
        }

        Node temp = head.next;
        Node newNode = reverseList2(head.next);
        temp.next = head;
        head.next = null;
        return newNode;
    }


    public static Node reverseList(Node head) {
        Node pre = head;
        Node cur = head.next;
        Node next;

        while (cur != null) {
            next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.setNext(null);
        return pre;
    }


    public static Node reverseList3(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node pre = head;
        Node cur = head.next;

        Node next;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;

        return pre;
    }

    public static Node reverseList4(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node temp = head.next;
        Node newNode = reverseList4(head.next);
        temp.next = head;
        head.next = null;
        return newNode;
    }
}
