package com.qg.fangrui.medium.code129;

import com.qg.fangrui.structure.TreeNode;

/**
 * Sum Root to Leaf Numbers
 * @author FunriLy
 * Created by FunriLy on 2018/2/6.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 先序遍历求解
     * @param node 当前结点
     * @param sum 存储值
     * @return 遍历结果
     */
    private static int helper(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int temp = sum*10 + node.val;
        if (node.left == null && node.right == null) {
            return temp;
        }
        return helper(node.left, temp) + helper(node.right, temp);
    }

    /**
     * 根据二叉树求统计值
     * @param root 二叉树根节点
     * @return 统计值
     */
    private static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, 0);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;

        System.out.println(sumNumbers(n1));
    }

}
