package com.qg.fangrui.medium.code059;

import java.util.Arrays;

/**
 * Spiral Matrix II
 * @author FunriLy
 * Created by FunriLy on 2018/1/21.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 将 n*n 的二维数组按照顺时针顺序填充
     * @param n 二维数组长宽
     * @return 构造好的二维数组
     */
    private static int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }

        int[][] matrix = new int[n][n];

        int index = 1;
        int x1=0, y1=0, x2=n-1, y2=n-1;

        while(x2 >= x1) {

            for (int i=y1; i<=y2; i++) {
                matrix[x1][i] = index++;
            }
            for (int i=x1+1; i<=x2; i++) {
                matrix[i][y2] = index++;
            }
            for (int i=y2-1; i>=y1; i--) {
                matrix[x2][i] = index++;
            }
            for (int i=x2-1; i>x1; i--) {
                matrix[i][y1] = index++;
            }

            x1++;
            y1++;
            x2--;
            y2--;
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] result = generateMatrix(3);
        if (result != null) {
            for (int[] list : result) {
                System.out.println(Arrays.toString(list));
            }
        }
    }
}
