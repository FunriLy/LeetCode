package com.qg.fangrui.medium.code086;

import com.qg.fangrui.structure.ListNode;

/**
 * ]Partition List
 * @author FunriLy
 * Created by FunriLy on 2018/1/27.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 将链表根据目标值分为两部分，并保证分区内相对位置不动
     * @param head 链表头结点
     * @param x 目标值
     * @return 新链表头结点
     */
    private static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        /*
        初始化两个链表指针结点
        1，存储小于目标值的结点；2、存储大于等于目标值的结点。
         */

        ListNode before = new ListNode(Integer.MIN_VALUE);
        ListNode curBefore = before;
        ListNode after = new ListNode(Integer.MAX_VALUE);
        ListNode curAfter = after;

        while (head != null) {
            if (head.val < x) {
                curBefore.next = head;
                curBefore = curBefore.next;
            } else {
                curAfter.next = head;
                curAfter = curAfter.next;
            }
            head = head.next;
        }

        curAfter.next = null;
        curBefore.next = after.next;
        return before.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        // 5->4->3->2->1
        ListNode.print(n1);

        ListNode node = partition(n1, 3);
        // 2->1->5->4->3 因为5、4、3大于等于目标值，所以位置不动
        ListNode.print(node);
    }
}
