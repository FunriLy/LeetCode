package com.qg.fangrui.easy.code083;

import com.qg.fangrui.structure.ListNode;

/**
 * Remove Duplicates from Sorted List
 * @author FunriLy
 * Created by FunriLy on 2018/1/20.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 删除链表中重复结点
     * @param head 链表头结点
     * @return 新链表头结点
     */
    private static ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode prve = root;
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                while (node.next != null && node.next.val == node.val) {
                    node = node.next;
                }
                prve.next = node;
                prve = prve.next;
            } else {
                prve = prve.next;
            }
            node = node.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode head = deleteDuplicates(n1);

        ListNode.print(head);
    }
}
