package com.qg.fangrui.easy.code112;

import com.qg.fangrui.structure.TreeNode;

/**
 * Path Sum
 * @author FunriLy
 * Created by FunriLy on 2018/1/29.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 检查二叉树中是否存在路径之和与指定值相等
     * @param root 二叉树根节点
     * @param sum 指定值
     * @return 若存在该路径返回 true 否则返回 false
     */
    private static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        int temp = sum - root.val;
        return (root.left == null && root.right == null && temp == 0)
                ||hasPathSum(root.left, temp) || hasPathSum(root.right, temp);
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
        TreeNode n9 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n4.left = n7;
        n4.right = n8;
        n6.right = n9;

        TreeNode.print(n1);
        System.out.println(hasPathSum(n1, 22));
    }
}
