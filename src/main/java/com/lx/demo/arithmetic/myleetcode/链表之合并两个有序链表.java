package com.lx.demo.arithmetic.myleetcode;

import com.lx.demo.arithmetic.common.ListNode;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 链表之合并两个有序链表 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result1 = mergeTwoLists2(l1,l2);
        while (result1 != null) {
            System.out.print(result1.val + " ");
            result1 = result1.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(-1);

        ListNode cur = l3;
        while(l1 != null || l2 != null) {
            if (l1 != null && l2 == null) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l1 == null && l2 != null) {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                if(l1.val <= l2.val ) {
                    cur.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    cur.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }
            cur = cur.next;
        }

        return l3.next;
    }


    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(-1);
        ListNode pre = l3;
        ListNode node = null;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 == null) {
                node = new ListNode(l1.val);
                l1 = l1.next;

            }
            if (l1 == null && l2 != null) {
                node = new ListNode(l2.val);
                l2 = l2.next;

            }
            if (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    node = new ListNode(l2.val);
                    l2 = l2.next;
                } else if (l1.val <= l2.val) {
                    node = new ListNode(l1.val);
                    l1 = l1.next;
                }
//                else if (l1.val == l2.val) {
//                    node = new ListNode(l2.val);
//                    l2 = l2.next;
//                    l1 = l1.next;
//                }
            }
            pre.next = node;
            pre = node;
        }
        return  l3.next;
    }
}
