package com.qg.fangrui.medium.code082;

import com.qg.fangrui.structure.ListNode;

/**
 * Remove Duplicates from Sorted List II
 * @author FunriLy
 * Created by FunriLy on 2018/1/26.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 去掉排序链表中重复元素
     * @param head 链表头结点
     * @return 新链表头结点
     */
    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode root = new ListNode(-1);
        root.next = head;

        // 三个指针：前、现在、后
        ListNode pre = root;
        ListNode cur = root.next;
        ListNode post = root.next.next;
        // 标志是否出现重复元素
        boolean flag = false;

        // 当还没有遍历到链表尾
        while (post != null) {
            if (cur.val == post.val) {
                // 如果当前结点与其后面结点值相同
                // 标记后继续递归找到第一个不同的结点
                flag = true;
                post = post.next;
                if (post == null) {
                    // 若元素尾部都是相同的结点，直接清除链表尾部
                    pre.next = null;
                }
            } else {
                if (flag) {
                    // 如果需要清除结点
                    pre.next = post;
                    flag = false;
                } else {
                    // 若不需要清除结点则正常移动三个指针
                    pre = cur;
                }
                cur = post;
                post = post.next;
            }
        }

        return root.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode.print(n1);
        ListNode node = deleteDuplicates(n1);
        ListNode.print(node);
    }
}
