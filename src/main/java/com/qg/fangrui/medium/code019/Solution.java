package com.qg.fangrui.medium.code019;

import com.qg.fangrui.structure.ListNode;

/**
 * Remove Nth Node From End of List
 * @author FunriLy
 * Created by FunriLy on 2018/1/12.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 求出移除链表末尾第 n 个结点
     * @param head 链表头
     * @param n 结点位置
     * @return 新链表头
     */
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null;
        }
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        if (n>len) {
            return null;
        } else if (n == len) {
            return head.next;
        }

        int i = 1;
        node = head;
        while (i != len-n) {
            node = node.next;
            i++;
        }
        node.next = node.next.next;
        return head;
    }

    /**
     * 《剑指 Offer》中查找循环链表的长度得到的思路
     * (上下两种效率其实是一样的，只是思路不一样)
     * @param head 链表头
     * @param n 结点位置
     * @return 新链表头
     */
    private static ListNode removeNthFromEndTwo(ListNode head, int n) {
        if(head == null || n <= 0){
            return null;
        }

        ListNode faster = head;
        ListNode slower = head;

        for(int i = 0; i<n; i++) {
            faster = faster.next;
        }

        if(faster == null){
            head = head.next;
            return head;
        }

        while(faster.next != null){
            slower = slower.next;
            faster = faster.next;
        }

        slower.next = slower.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode.print(n1);
        // 去掉4号结点
        ListNode node = removeNthFromEnd(n1, 2);
        ListNode.print(node);
        // 去掉1号结点
        node = removeNthFromEndTwo(n1, 4);
        ListNode.print(node);
    }
}
