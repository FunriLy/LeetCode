package com.qg.fangrui.easy.code035;

/**
 * Search Insert Position
 * @author FunriLy
 * Created by FunriLy on 2018/1/8.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 顺序查找所在或者插入位置
     * @param nums 给定数组
     * @param target 目标值
     * @return 查找位置
     */
    private static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        for (int i=0; i<n; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return n;
    }

    /**
     * 二分法查找所在或者插入位置
     * @param nums 给定数组
     * @param target 目标值
     * @return 查找位置
     */
    private static int searchInsertTwo(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // 这里不能 +1 的原因是因为该索引可能是插入位置
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
    }
}
