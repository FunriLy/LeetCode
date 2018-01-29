package com.qg.fangrui.easy.code107;

import com.qg.fangrui.structure.TreeNode;

import java.util.*;

/**
 * Binary Tree Level Order Traversal II
 * @author FunriLy
 * Created by FunriLy on 2018/1/29.
 * From small beginnings comes great things.
 */
public class Solution {

    // todo:可以尝试提高效率

    /**
     * 层次遍历，获得二叉树每一层的元素集合
     * @param root 二叉树根节点
     * @return 二叉树层次遍历元素集合
     */
    private static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        Stack<List<Integer>> stack = new Stack<>();

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
            if (!list.isEmpty()) {
                List<Integer> tempList = new ArrayList<>();
                for (int j=list.size()-1; j>=0; j--) {
                    tempList.add(list.get(j));
                }
                stack.add(tempList);
            }
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        TreeNode.print(n1);
        List<List<Integer>> result = levelOrderBottom(n1);
        result.forEach(System.out::println);
    }
}
