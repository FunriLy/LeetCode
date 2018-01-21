package com.qg.fangrui.medium.code054;

import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Matrix
 * @author FunriLy
 * Created by FunriLy on 2018/1/21.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 将二维数组加入到集合中
     * @param matrix 二维数组
     * @return 存储集合
     */
    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        rec(matrix, 0, 0, matrix.length, matrix[0].length, result);
        return result;
    }

    /**
     * 将给定二维数组一圈数据加入到集合中
     * @param matrix 二维数组
     * @param x 索引 x 坐标
     * @param y 索引 y 坐标
     * @param rows 该圈高度
     * @param cols 该圈长度
     * @param result 存储集合
     */
    private static void rec(int[][] matrix, int x, int y, int rows, int cols, List<Integer> result) {
        if (rows <= 0 || cols <= 0) {
            return;
        }

        // first line
        for (int i = 0; i < cols; i++) {
            result.add(matrix[x][y + i]);
        }

        // right column
        for (int i = 1; i < rows - 1; i++) {
            result.add(matrix[x + i][y + cols - 1]);
        }

        // down row
        if (rows > 1) {
            for (int i = cols - 1; i >= 0; i--) {
                result.add(matrix[x + rows - 1][y + i]);
            }
        }

        // left column.
        if (cols > 1) {
            for (int i = rows - 2; i > 0; i--) {
                result.add(matrix[x + i][y]);
            }
        }

        rec (matrix, x + 1, y + 1, rows - 2, cols - 2, result);
    }

    public static void main(String[] strs) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> result = spiralOrder(matrix);
        System.out.println(result);
    }
}
