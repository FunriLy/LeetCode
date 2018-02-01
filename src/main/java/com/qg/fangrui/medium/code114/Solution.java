package com.qg.fangrui.medium.code114;

import com.qg.fangrui.structure.TreeNode;

import java.util.Stack;

/**
 * Flatten Binary Tree to Linked List
 * @author FunriLy
 * Created by FunriLy on 2018/2/1.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 递归解法：这是一种先序遍历
     * 将二叉树拆分为链表
     * @param root 二叉树根节点
     */
    private static void flattenTwo(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            flattenTwo(root.left);
        }
        if (root.right != null) {
            flattenTwo(root.right);
        }

        // 保留右子树 并将左子树连接到目标节点
        TreeNode node = root.right;
        root.right = root.left;
        root.left = null;
        // 移动指针到目标结点新右子树尾部 并将旧右子树连接上去
        TreeNode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = node;
    }

    /**
     * 非递归解法：利用栈的解法
     * 将二叉树拆分为链表
     * @param root 二叉树根节点
     */
    private static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

            node.left = null;
            if (stack.isEmpty()) {
                node.right = null;
            } else {
                node.right = stack.peek();
            }
        }
    }

    public static void main(String[] args) {
        TreeNode n11 = new TreeNode(1);
        TreeNode n12 = new TreeNode(2);
        TreeNode n13 = new TreeNode(3);
        TreeNode n14 = new TreeNode(4);
        TreeNode n15 = new TreeNode(5);
        TreeNode n16 = new TreeNode(6);

        n11.left = n12;
        n11.right = n13;
        n12.left = n14;
        n13.left = n15;
        n13.right = n16;

        TreeNode.print(n11);
        flatten(n11);
        TreeNode.print(n11);

        System.out.println("=======================");

        TreeNode n21 = new TreeNode(1);
        TreeNode n22 = new TreeNode(2);
        TreeNode n23 = new TreeNode(3);
        TreeNode n24 = new TreeNode(4);
        TreeNode n25 = new TreeNode(5);
        TreeNode n26 = new TreeNode(6);

        n21.left = n22;
        n21.right = n23;
        n22.left = n24;
        n23.left = n25;
        n23.right = n26;

        TreeNode.print(n21);
        flattenTwo(n21);
        TreeNode.print(n21);
    }
}
