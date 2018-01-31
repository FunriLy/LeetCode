package com.qg.fangrui.medium.code103;

import com.qg.fangrui.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Zigzag Level Order Traversal
 * @author FunriLy
 * Created by FunriLy on 2018/1/31.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 按之字型顺序打印二叉树
     * @param root 二叉树根节点
     * @return 存储树元素的集合
     */
    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        queue.add(root);
        // 记录遍历是否需要换层
        int size = 1;
        // 标志从左边读入还是右边
        boolean flag = true;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (flag) {
                list.add(node.val);
            } else {
                list.addFirst(node.val);
            }

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            size--;
            if (size == 0) {
                // 遍历换层
                result.add(list);
                size = queue.size();
                if (size != 0) {
                    // 构造新存储集合
                    list = new LinkedList<>();
                }
                // 重置相反标志
                flag = !flag;
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

        List<List<Integer>> result = zigzagLevelOrder(n1);
        result.forEach(System.out::println);
    }
}
