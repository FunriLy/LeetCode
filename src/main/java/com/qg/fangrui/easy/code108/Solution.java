package com.qg.fangrui.easy.code108;

import com.qg.fangrui.structure.TreeNode;

/**
 * Convert Sorted Array to Binary Search Tree
 * @author FunriLy
 * Created by FunriLy on 2018/1/29.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 将数组区间构造左右子树深度不大于 1 的二叉树
     * @param nums 数组
     * @param start 起始索引
     * @param end 终止索引
     * @return 二叉树根节点
     */
    private static TreeNode createRootNode(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new TreeNode(nums[start]);
        }

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = createRootNode(nums, start, mid-1);
        node.right = createRootNode(nums, mid+1, end);
        return node;
    }

    /**
     * 将给定数组构造平衡搜索二叉树
     * @param nums 排序后数组
     * @return 二叉树根节点
     */
    private static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return createRootNode(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode node = sortedArrayToBST(nums);
        TreeNode.print(node);
    }
}
