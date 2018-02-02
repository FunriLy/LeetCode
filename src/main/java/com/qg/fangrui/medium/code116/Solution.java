package com.qg.fangrui.medium.code116;

import com.qg.fangrui.structure.TreeLinkNode;

/**
 * Populating Next Right Pointers in Each Node
 * @author FunriLy
 * Created by FunriLy on 2018/2/2.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 将二叉树结构转化为链树结构
     * @param root 树根节点
     */
    private static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null) {
            if (root.next != null) {
                root.right.next = root.next.left;
            } else {
                root.right.next = null;
            }
        }

        connect(root.left);
        connect(root.right);
    }

    /**
     * 自定义输出函数
     * @param node 链树结构节点
     */
    private static void printf(TreeLinkNode node) {
        System.out.print("[");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n7 = new TreeLinkNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        connect(n1);
        printf(n1);
        printf(n2);
        printf(n4);
    }
}
