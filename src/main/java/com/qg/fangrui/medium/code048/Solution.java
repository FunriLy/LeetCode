package com.qg.fangrui.medium.code048;

import java.util.Arrays;

/**
 * Rotate Image
 * @author FunriLy
 * Created by FunriLy on 2018/1/18.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 顺时针旋转二维数组
     * @param matrix 给定二维数组
     */
    private static void rotate(int[][] matrix) {

        if (matrix == null) {
            return;
        }

        int n = matrix.length;
        for (int i=0; i<n/2; i++) {
            for (int j=i; j<n-i-1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix);
        for (int[] list : matrix) {
            System.out.println(Arrays.toString(list));
        }
    }
}
