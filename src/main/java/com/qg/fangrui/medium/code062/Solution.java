package com.qg.fangrui.medium.code062;

import java.util.Arrays;

/**
 * Unique Paths
 * @author FunriLy
 * Created by FunriLy on 2018/1/23.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 求机器人从棋盘左上角顶点到右下角顶点的走法数
     * 且机器人只能向右或者向下移动
     * 采用动态规划算法 : path[i][j] = path[i-1][j] + path[i][j-1]
     * @param m 棋盘高度
     * @param n 棋盘长度
     * @return 走法数
     */
    private static int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[][] path = new int[m][n];
        for (int i=0; i<n; i++) {
            path[0][i] = 1;
        }
        for (int i=0; i<m; i++) {
            path[i][0] = 1;
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                path[i][j] = path[i-1][j] + path[i][j-1];
            }
        }
        return path[m-1][n-1];
    }

    /**
     * LeetCode 上一种更快的解法，也是采用了动态规划算法
     * 避免采用了二维数组，依照一个数组从左到右依次计算来更新值，以达到二维数组的模拟
     * @param m 棋盘高度
     * @param n 棋盘长度
     * @return 走法数
     */
    private static int uniquePaths2(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row,1);
        for ( int i = 1; i < m; i++){
            for ( int j = 1; j < n; j++){
                row[j]+=row[j-1];
            }
        }
        return row[n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths2(3, 7));
    }
}
