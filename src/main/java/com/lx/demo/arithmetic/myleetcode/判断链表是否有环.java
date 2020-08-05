package com.lx.demo.arithmetic.myleetcode;

import com.lx.demo.arithmetic.common.ListNode;

public class 判断链表是否有环 {
    public static void main(String[] args) {

    }

    /**
     * 判断是否有环
     * @param head
     * @return
     */
    public static boolean containLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast.val == slow.val) {
                return true;
            }
        }
        return false;
    }

    /**
     * 计算环的长度
     * @param head
     * @return
     */
    public static int countLoopLength(ListNode head) {
        if(containLoop(head) == false)
            return 0;
        ListNode fast = head;
        ListNode slow = head;
        int length = 0;
        boolean begin = false;
        boolean agian = false;
        while( fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //超两圈后停止计数，挑出循环
            if(fast == slow && agian == true)
                break;
            //超一圈后开始计数
            if(fast == slow && agian == false) {
                begin = true;
                agian = true;
            }
            //计数
            if(begin == true)
                ++ length;
        }
        return length;
    }

    public static ListNode findLoopEntrance(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast.val == slow.val) {
                break;
            }
        }

        if (fast == null && fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
