package com.lx.link;

public class ReverseLink {

    static class Node {
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

        //Node newNode = reverse(head);
        Node newNode = new Node(-1);
        if (head == null) {
            head = newNode;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.data == 4) {
                Node t2 = temp.next;
                newNode.next = t2;
                temp.next = newNode;
            }
            temp = temp.next;
        }

        while (head != null) {
            Node node = head.next;
            System.out.print(head.data);
            System.out.print(" ");
            head = node;
        }

    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head.next;
        Node newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    public static Node reverseList(Node node) {
        Node pre = null;
        Node next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
