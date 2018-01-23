package com.qg.fangrui.medium.code063;

/**
 * Unique Paths II
 * @author FunriLy
 * Created by FunriLy on 2018/1/23.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 增加了障碍物的版本，参考上一题
     * 这里只要将上一题的解法增加一个规则即可：遇到障碍物则该处解法设置为 0
     * @param obstacleGrid 给定棋盘数据
     * @return 走法数
     */
    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (m == 0 || n == 0 || obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }

        int[][] path = new int[m][n];
        path[0][0] = 1;
        for (int i=1; i<n; i++) {
            if (obstacleGrid[0][i] == 1) {
                path[0][i] = 0;
                break;
            } else {
                path[0][i] = 1;
            }
        }

        for (int i=1; i<m; i++){
            if (obstacleGrid[i][0] == 1) {
                path[i][0] = 0;
                break;
            } else {
                path[i][0] = 1;
            }
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    path[i][j] = 0;
                } else {
                    path[i][j] = path[i-1][j] + path[i][j-1];
                }
            }
        }
        return path[m-1][n-1];
    }
}
