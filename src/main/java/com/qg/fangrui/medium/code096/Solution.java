package com.qg.fangrui.medium.code096;

/**
 * Unique Binary Search Trees
 * @author FunriLy
 * Created by FunriLy on 2018/1/29.
 * From small beginnings comes great things.
 */
public class Solution {

    /*
    已知 (0,0)、(1,1)、(2,2)、(3,5)……假设 f(0) = 1
    以 n=3 为例子
    当根节点为1，则数量为 f(0)*f(2)
    当根节点为2，则数量为 f(1)*f(1)
    当根节点为3，则数量为 f(2)*f(0)

    所以，综上可得
    f(0) = 1;
    f(n) = f(0)*f(n-1) + f(1)*f(n-2) + …… + f(n-2)*f(1) + f(n)*f(1)
     */

    /**
     * 求解1-n能够构造多少种不同的搜索二叉树
     * @param n 范围数值
     * @return 不同BST树的数量
     */
    private static int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] nums = new int[n+1];
        // 初始化当有0个节点时，只有一种解法
        nums[0] = 1;

        for (int i=1; i<=n; i++) {
            // 构造有 i 个节点树的数量
            for (int j=0; j<i; j++) {
                nums[i] += nums[j] * nums[i-1-j];
            }
        }
        return nums[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
