package com.qg.fangrui.easy.code101;

import com.qg.fangrui.structure.TreeNode;

/**
 * Symmetric Tree
 * @author FunriLy
 * Created by FunriLy on 2018/1/29.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 判断左右两颗树是否镜面对称
     * @param leftTree 左树根节点
     * @param rightTree 右树根节点
     * @return 若两树镜面对称返回 true 否则返回 false
     */
    private static boolean isEqual(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null) {
            // 如果左孩子为 null 则取决于右孩子
            return rightTree == null;
        } else if (rightTree == null) {
            // 若左孩子不为 null 右孩子为 null 返回 false
            return false;
        }
        // 检查节点的值，以及左右子树
        return leftTree.val == rightTree.val && isEqual(leftTree.left, rightTree.right) && isEqual(leftTree.right, rightTree.left);
    }

    /**
     * 判断给定二叉树是否左右对称
     * @param root 二叉树根节点
     * @return 若二叉树对称返回 true 否则返回 false
     */
    private static boolean isSymmetric(TreeNode root) {
        return root == null || isEqual(root.left, root.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);

        n1.left = new TreeNode(2);

        TreeNode.print(n1);
        System.out.println(isSymmetric(n1));
    }
}
