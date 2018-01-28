package com.qg.fangrui.medium.code092;

import com.qg.fangrui.structure.ListNode;

/**
 * Reverse Linked List II
 * @author FunriLy
 * Created by FunriLy on 2018/1/28.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 将链表指定范围结点反转
     * @param head 链表头结点
     * @param m 起始索引
     * @param n 终止索引
     * @return 新链表头结点
     */
    private static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m <= 0 || n <= 0 || m >= n) {
            return head;
        }
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode pre = root;

        int i = 1;
        // 获得前面不动的一部分
        while (pre.next != null && i < m) {
            pre = pre.next;
            i++;
        }
        if (i<m) {
            return head;
        }

        ListNode mNode = pre.next;
        ListNode current = mNode.next;
        while (current != null && i < n) {
            // 取出反转点
            ListNode next = current.next;
            current.next = pre.next;
            pre.next = current;
            mNode.next = next;
            current = next;
            i++;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=null;
        ListNode.print(n1);

        ListNode node = reverseBetween(n1, 2, 4);
        ListNode.print(node);
    }
}
