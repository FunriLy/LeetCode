package com.qg.fangrui.medium.code106;

import com.qg.fangrui.structure.TreeNode;

/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 * @author FunriLy
 * Created by FunriLy on 2018/1/31.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 根据先序遍历与中序遍历结果构造二叉树
     * @param inorder 中序遍历结果
     * @param postorder 后序遍历结果
     * @param postend 后序遍历终止索引
     * @param inStart 中序遍历开始索引
     * @param inEnd 中序遍历终止索引
     * @return 二叉树根节点
     */
    private static TreeNode helper(int[] inorder, int[] postorder,
                                   int postend, int inStart, int inEnd) {
        if (inStart > inEnd || postend < 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postend]);
        int index = 0;
        for (int i=inStart; i<=inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        root.left = helper(inorder, postorder, postend-inEnd+index-1, inStart, index-1);
        root.right = helper(inorder, postorder, postend-1, index+1, inEnd);
        return root;
    }

    /**
     * 根据先序遍历与中序遍历结果构造二叉树
     * @param inorder 中序遍历结果
     * @param postorder 后序遍历结果
     * @return 二叉树根节点
     */
    private static TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, postorder.length-1, 0, inorder.length-1);
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode node = buildTree(inorder, postorder);
        TreeNode.print(node);
    }
}
