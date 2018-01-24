package com.qg.fangrui.medium.code073;

import java.util.Arrays;

/**
 * Set Matrix Zeroes
 * @author FunriLy
 * Created by FunriLy on 2018/1/24.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 将矩阵值为0所在的行与列全部置 0
     * @param matrix 位二维矩阵
     */
    private static void setZeroes(int[][] matrix) {

        /*
        先对矩阵进行扫描，标记要进行置0的行和列，对要进行置0的行在第0列上进行标记，对置0的列在第0行上进行标标记。
        同时还要两变量记录第0行和第0列是否要置0，最后进行置0操作。
         */

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        boolean rowFlag = false, colFlag = false;

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    // 检查第一行和列是否要置 0
                    if (i == 0) {
                        rowFlag = true;
                    }
                    if (j == 0) {
                        colFlag = true;
                    }

                    // 在第一行和列相应位置置 0
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i=1; i<matrix.length; i++) {
            for (int j=1; j<matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (rowFlag) {
            for (int j=0; j<matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (colFlag) {
            for (int i=0; i<matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeroes(matrix);

        for (int[] list : matrix) {
            System.out.println(Arrays.toString(list));
        }
    }
}
