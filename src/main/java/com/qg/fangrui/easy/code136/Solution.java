package com.qg.fangrui.easy.code136;

/**
 * Single Number
 * @author FunriLy
 * Created by FunriLy on 2018/1/30.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 求只出现一次的数字
     * @param nums 整数数组
     * @return 只出现一次的数字元素
     */
    private static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 3, 4, 3, 2, 1}));
    }
}
