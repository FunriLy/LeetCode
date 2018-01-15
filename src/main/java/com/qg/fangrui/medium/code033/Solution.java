package com.qg.fangrui.medium.code033;

/**
 * Search in Rotated Sorted Array
 * @author FunriLy
 * Created by FunriLy on 2018/1/15.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 从给定数组(排序后轮转)中找到目标值
     * @param nums 给定数组
     * @param target 目标值
     * @return 若找到目标值返回其索引，否则返回 -1
     */
    private static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[start]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1}, 0));
    }
}
