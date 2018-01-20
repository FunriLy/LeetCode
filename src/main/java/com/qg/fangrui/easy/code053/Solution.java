package com.qg.fangrui.easy.code053;

/**
 * Maximum Subarray
 * @author FunriLy
 * Created by FunriLy on 2018/1/20.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 由给定数组中找到最大连续子数组之和
     * @param nums 给定数组
     * @return 最大连续子数组之和
     */
    private static int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1}));
    }
}
