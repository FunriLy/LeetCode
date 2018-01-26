package com.qg.fangrui.medium.code080;

/**
 * Remove Duplicates from Sorted Array II
 * @author FunriLy
 * Created by FunriLy on 2018/1/26.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 只允许重复数字出现一次
     * @param nums 排序数组
     * @return 调整后的数组长度
     */
    private static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0, index = 0;
        for (int i=0; i<nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                count++;
                if (count >= 3) {
                    continue;
                }
            } else {
                count = 1;
            }
            nums[index++] = nums[i];
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2, 2, 3, 3, 3}));
    }
}
