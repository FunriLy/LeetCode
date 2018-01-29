package com.qg.fangrui.medium.code094;

import com.qg.fangrui.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Inorder Traversal
 * @author FunriLy
 * Created by FunriLy on 2018/1/29.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 递归求解先序遍历
     * @param result 结果集
     * @param node 当前遍历结点
     */
    private static void  inorderTree(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTree(result, node.left);
        result.add(node.val);
        inorderTree(result, node.right);
    }

    /**
     * 求给定根结点的先序遍历结果
     * @param root 根结点
     * @return 结果集
     */
    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        inorderTree(result, root);
        return result;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n1.left = null;
        n1.right = n2;
        n2.left = n3;
        n2.right = null;

        List<Integer> result = inorderTraversal(n1);
        System.out.println(result.toString());
    }
}
