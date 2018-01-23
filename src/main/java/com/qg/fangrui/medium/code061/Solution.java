package com.qg.fangrui.medium.code061;

import com.qg.fangrui.structure.ListNode;

/**
 * Rotate List
 * @author FunriLy
 * Created by FunriLy on 2018/1/23.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 旋转链表
     * @param head 给定链表头结点
     * @param k 倒数索引位置
     * @return 旋转后链表头结点
     */
    private static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k <= 0) {
            return head;
        }


        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode currentNode = head;
        // 先遍历一遍数组，统计个数，防止 k 越界
        int len = 0;
        while (currentNode != null) {
            len++;
            currentNode = currentNode.next;
        }
        k = k % len;

        // 如果链表长度与 k 相等，则直接返回数组
        if (k == 0) {
            return head;
        }

        // 利用快慢指针
        ListNode headFirst = head, headSecond = head;
        while (k>0) {
            headFirst = headFirst.next;
            k--;
        }
        // 找到目标结点的上一个结点
        while (headFirst.next != null) {
            headFirst = headFirst.next;
            headSecond = headSecond.next;
        }
        // 移位操作
        root.next = headSecond.next;
        headSecond.next = null;
        headFirst.next = head;
        return root.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        //n2.next = n3;
        //n3.next = n4;
        //n4.next = n5;

        ListNode node = rotateRight(n1, 2);
        System.out.println(node.val);
        ListNode.print(node);
    }
}
