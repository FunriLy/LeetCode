package com.qg.fangrui.medium.code095;

import com.qg.fangrui.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Unique Binary Search Trees II
 * @author FunriLy
 * Created by FunriLy on 2018/1/29.
 * From small beginnings comes great things.
 */
public class Solution {

    /*
    参考资料 : https://www.jiuzhang.com/solution/unique-binary-search-trees-ii/
     */

    /**
     * 给定起始范围构造搜索二叉树
     * @param start 起始值
     * @param end 终止值
     * @return 二叉树集合
     */
    private static List<TreeNode> createTreeAtRoot(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i=start; i<=end; i++) {
            // 以i作为根节点，左子树由[1,i-1]构成
            List<TreeNode> left = createTreeAtRoot(start, i-1);
            // 右子树由[i+1, n]构成
            List<TreeNode> right = createTreeAtRoot(i+1, end);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }

        }
        return result;
    }

    /**
     * 由1-n构造不同的搜索二叉树
     * @param n 范围数值
     * @return 二叉树集合
     */
    private static List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return createTreeAtRoot(1, n);
    }

    public static void main(String[] args) {
        List<TreeNode> result = generateTrees(3);
        for (TreeNode root : result) {
            TreeNode.print(root);
            System.out.println("=================");
        }
    }
}
