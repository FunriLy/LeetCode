package com.qg.fangrui.medium.code113;

import com.qg.fangrui.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Path Sum II
 * @author FunriLy
 * Created by FunriLy on 2018/2/1.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 递归检查当前节点
     * @param node 当前节点
     * @param sum 目标值
     * @param result 存储结果集合
     * @param list 当前路线
     */
    private static void helper(TreeNode node, int sum, List<List<Integer>> result, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);
        if (node.left == null && node.right == null && sum == node.val) {
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        } else {
            helper(node.left, sum - node.val, result, list);
            helper(node.right, sum - node.val, result, list);
        }
        list.remove(list.size() - 1);
    }

    /**
     * 找到所有可能路径
     * @param root 二叉树根节点
     * @param sum 目标值
     * @return 所有可能路径的集合
     */
    private static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(root, sum, result, list);
        return result;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(5);
        TreeNode n10 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n4.left = n7;
        n4.right = n8;
        n6.left = n9;
        n6.right = n10;
        TreeNode.print(n1);

        List<List<Integer>> result = pathSum(n1, 22);
        result.forEach(System.out::println);
    }

}
