package com.qg.fangrui.medium.code074;

/**
 * Search a 2D Matrix
 * @author FunriLy
 * Created by FunriLy on 2018/1/24.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 从给定二维数组中找到目标值
     * @param matrix 二维数组
     * @param target 目标值
     * @return 若找到目标值返回 true 否则返回 false
     */
    private static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || target < matrix[0][0]) {
            return false;
        }

        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (target < matrix[i][j]) {
                i--;
            } else if (target > matrix[i][j]) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        System.out.println(searchMatrix(matrix, 3));
    }
}
