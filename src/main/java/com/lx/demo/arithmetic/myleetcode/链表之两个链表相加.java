package com.lx.demo.arithmetic.myleetcode;

import com.lx.demo.arithmetic.common.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/add-two-numbers
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 链表之两个链表相加 {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);

        ListNode l2 = null;

        ListNode result = addTwoNumbers(l1,l2);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(-1);
        ListNode pre = l3;

        int carry = 0; //表示进位
        int temp = 0;
        while (l1 != null || l2 != null || carry > 0) {
            temp = carry;
            temp = l1 == null ? 0 + temp : l1.val + temp;
            temp = l2 == null ? 0 + temp : l2.val + temp;

            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;

            carry = temp / 10;
            temp = temp % 10;

            ListNode node = new ListNode(temp);
            pre.next = node;
            pre = node;

        }

        return l3.next;


    }
}
