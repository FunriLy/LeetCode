package com.qg.fangrui.medium.code064;

/**
 * Minimum Path Sum
 * @author FunriLy
 * Created by FunriLy on 2018/1/23.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 和上两题同种解法，只不过给每个格子赋值了，求数字最小路径之和
     * @param grid 给定二维数组
     * @return 路径之和
     */
    public int minPathSum(int[][] grid) {

        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }

        for (int i=1; i<n; i++) {
            grid[0][i] += grid[0][i-1];
        }

        for (int i=1; i<m; i++) {
            grid[i][0] += grid[i-1][0];
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }

        return grid[m-1][n-1];
    }
}
