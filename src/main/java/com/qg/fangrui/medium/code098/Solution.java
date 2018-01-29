package com.qg.fangrui.medium.code098;

import com.qg.fangrui.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Validate Binary Search Tree
 * @author FunriLy
 * Created by FunriLy on 2018/1/29.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 根据给定结点进行先序遍历
     * @param node 当前结点
     * @param result 存储结点值的集合
     */
    private static void  preOrder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            preOrder(node.left, result);
        }
        result.add(node.val);
        if (node.right != null) {
            preOrder(node.right, result);
        }
    }

    /**
     * 判断给定二叉树是否是搜索二叉树
     * @param root 二叉树根节点
     * @return 若该树为搜索二叉树返回 true 负责返回false
     */
    private static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> result = new ArrayList<>();
        // 先序遍历构造数值排序集合
        preOrder(root, result);
        for (int i=0; i<result.size()-1; i++) {
            if (result.get(i) >= result.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 非递归解法 : 来源于 LeetCode
     * @param root 二叉树根节点
     * @return 若该树为搜索二叉树返回 true 负责返回false
     */
    private static boolean isValidBSTFromLeetCode(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            // 不断对根节点左节点进行深入并入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 依次取出最深的左节点
            root = stack.pop();
            if(pre != null && root.val <= pre.val) {
                return false;
            }
            // 节点上移，pre记录上一个结点的左孩子
            pre = root;
            // 此时准备对右结点进行入栈
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(20);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        TreeNode.print(n1);
        System.out.println(isValidBST(n1));
        System.out.println(isValidBSTFromLeetCode(n1));
    }
}
