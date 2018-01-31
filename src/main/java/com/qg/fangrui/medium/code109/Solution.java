package com.qg.fangrui.medium.code109;

import com.qg.fangrui.structure.ListNode;
import com.qg.fangrui.structure.TreeNode;

/**
 * Convert Sorted List to Binary Search Tree
 * @author FunriLy
 * Created by FunriLy on 2018/1/31.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 将给定数组构造平衡搜索二叉树
     * @param head 排序数组
     * @return 二叉树根节点
     */
    private static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        // 定义三个索引 慢指针 快指针 区间分区指针
        ListNode slow = head, fast = head, last = head;
        while (fast.next != null && fast.next.next != null) {
            last = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // 利用快指针将链表分为两个区间
        fast = slow.next;
        last.next = null;
        // 构造结点
        TreeNode node = new TreeNode(slow.val);
        if (head != slow) {
            node.left = sortedListToBST(head);
        }
        node.right = sortedListToBST(fast);
        return node;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);


        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        ListNode.print(n1);

        TreeNode node = sortedListToBST(n1);
        TreeNode.print(node);
    }
}
