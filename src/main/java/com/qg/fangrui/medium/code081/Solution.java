package com.qg.fangrui.medium.code081;

/**
 * Search in Rotated Sorted Array II
 * @author FunriLy
 * Created by FunriLy on 2018/1/26.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 检查旋转数组中是否含有目标值(数组中允许出现重复元素)
     * @param nums 数组
     * @param target 目标值
     * @return 若在数组中找到目标值返回 true 否则返回 false
     */
    private static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            // 二分法
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] > nums[start]) {
                // 中间值大于起始值，证明两者中间是排序好的
                if (nums[mid] > target && nums[start] <= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] < nums[start]) {
                // 中间值小于起始值，说明中间值到终止值之间是排序好的
                if (nums[mid] < target && nums[end] >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                start++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 3, 1, 1, 1, 1}, 3));
    }
}
