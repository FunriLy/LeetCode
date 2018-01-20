package com.qg.fangrui.easy.code066;

import java.util.Arrays;

/**
 * Plus One
 * @author FunriLy
 * Created by FunriLy on 2018/1/20.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 将一个用数组存储的整数执行 +1 操作
     * @param digits 存储数组
     * @return +1 操作后存储的数组
     */
    private static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i=n-1; i>=0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[n+1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        int[] result = plusOne(new int[]{9,9,9,9});
        if (result != null) {
            System.out.println(Arrays.toString(result));
        } else {
            System.out.println("null");
        }
    }
}
