package com.qg.fangrui.medium.code102;

import com.qg.fangrui.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Level Order Traversal
 * @author FunriLy
 * Created by FunriLy on 2018/1/31.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 层次遍历二叉树
     * @param root 二叉树根节点
     * @return 存储树的元素的集合
     */
    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (!list.isEmpty()) {
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        TreeNode.print(n1);

        List<List<Integer>> result = levelOrder(n1);
        result.forEach(System.out::println);
    }
}
