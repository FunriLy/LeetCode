package com.qg.fangrui.easy.code026;

/**
 * Remove Duplicates from Sorted Array
 * @author FunriLy
 * Created by FunriLy on 2018/1/8.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 移除数组中重复的元素
     * @param nums 给定数组
     * @return 新数组长度
     */
    private static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,4,5,6};
        System.out.println(removeDuplicates(nums));
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
