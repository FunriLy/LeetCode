package com.qg.fangrui.easy.code027;

/**
 * Remove Element
 * @author FunriLy
 * Created by FunriLy on 2018/1/8.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 移除数组中指定元素
     * @param nums 给定数组
     * @param val 指定元素
     * @return 返回新数组长度
     */
    private static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0, n = nums.length;
        for (int i=0; i<n; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        System.out.println(removeElement(nums, 3));
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
