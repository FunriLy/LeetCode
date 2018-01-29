package com.qg.fangrui.easy.code110;

import com.qg.fangrui.structure.TreeNode;

/**
 * Balanced Binary Tree
 * @author FunriLy
 * Created by FunriLy on 2018/1/29.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 判断二叉树左右子树深度是否平衡
     * @param root 二叉树根节点
     * @param depth 记录当前节点深度，用于返回计算
     * @return 若二叉树平衡返回 true 否则返回 false
     */
    private static boolean isBalanced(TreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }
        int[] left = new int[1];
        int[] right = new int[1];
        if (isBalanced(root.left, left) && isBalanced(root.right, right)) {
            int diff = left[0] - right[0];
            if (diff <= 1 && diff >= -1) {
                depth[0] = 1 + Math.max(left[0], right[0]);
                return true;
            }
        }
        return false;
    }

    /**
     * 判断二叉树左右子树深度是否平衡
     * @param root 二叉树根节点
     * @return 若二叉树平衡返回 true 否则返回 false
     */
    private static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int[] depth = new int[1];
        depth[0] = 0;
        return isBalanced(root, depth);
    }

    public static void main(String[] args) {
        System.out.println(isBalanced(null));
    }
}
