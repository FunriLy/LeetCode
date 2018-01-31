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
     * 记录当前操作链表
     */
    private ListNode current;

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

    /**
     * 获得链表长度
     * @param head 链表头结点
     * @return 返回链表长度
     */
    private int getSize(ListNode head){
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
    }

    /**
     * 根据列表长度构造二叉树
     * @param size 链表长度
     * @return 二叉树根节点
     */
    private TreeNode sortedListToBSTHelper(int size){
        if (size <= 0){
            return null;
        }

        // 构造左子树
        TreeNode left = sortedListToBSTHelper(size / 2);
        // 构造当前结点
        TreeNode root = new TreeNode(current.val);
        // 链表指针移动
        current = current.next;
        // 构造右子树
        TreeNode right = sortedListToBSTHelper(size - size / 2 - 1);
        root.left = left;
        root.right = right;

        return root;
    }

    /**
     * 将给定数组构造平衡搜索二叉树
     * 更加高效的方法
     * @param head 排序数组
     * @return 二叉树根节点
     */
    private TreeNode sortedListToBSTTwo(ListNode head) {
        if (head == null){
            return null;
        }
        current = head;
        int size = getSize(head);
        return sortedListToBSTHelper(size);
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

        Solution solution = new Solution();
        TreeNode root = solution.sortedListToBSTTwo(n1);
        TreeNode.print(root);

        TreeNode node = sortedListToBST(n1);
        TreeNode.print(node);


    }
}
