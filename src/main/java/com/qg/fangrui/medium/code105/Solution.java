package com.qg.fangrui.medium.code105;

import com.qg.fangrui.structure.TreeNode;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 * @author FunriLy
 * Created by FunriLy on 2018/1/31.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 根据先序遍历与中序遍历结果构造二叉树
     * @param preorder 先序遍历结果
     * @param inorder 中序遍历结果
     * @param preStart 先序遍历开始索引
     * @param inStart 中序遍历开始索引
     * @param inEnd 中序遍历终止索引
     * @return 二叉树根节点
     */
    private static TreeNode helper(int[] preorder, int[] inorder,
                                   int preStart, int inStart, int inEnd) {
        if (preStart > preorder.length-1 || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        for (int i=inStart; i<=inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        // 构造左子树 先序遍历索引+1
        root.left = helper(preorder, inorder, preStart+1, inStart, index-1);
        // 构造右子树 先序遍历索引+左子树长度+1
        root.right = helper(preorder, inorder, preStart+index-inStart+1, index+1, inEnd);
        return root;
    }

    /**
     * 根据先序遍历与中序遍历结果构造二叉树
     * @param preorder 先序遍历结果
     * @param inorder 中序遍历结果
     * @return 二叉树根节点
     */
    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length-1);
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode node = buildTree(preorder, inorder);
        TreeNode.print(node);
    }
}
