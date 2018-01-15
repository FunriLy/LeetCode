package com.qg.fangrui.medium.code034;

import java.util.Arrays;

/**
 * Search for a Range
 * @author FunriLy
 * Created by FunriLy on 2018/1/15.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 采用前后扫描来查找区间…………证明 leetcode 没有对时间复杂度运行时间进行判断
     * 时间复杂度 O(n)
     * @param nums 排序数组
     * @param target 目标值
     * @return 元素区间起始、终止索引集合，若不存在则返回 {1, -1}
     */
    private static int[] searchRangeTest(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[]{-1, -1};
        }

        int[] result = new int[2];
        int start = 0;
        for (; start<nums.length; start++) {
            if (target == nums[start]) {
                break;
            }
        }

        if (start >= 0 && start <= nums.length-1) {
            result[0] = start;
        } else {
            return new int[]{-1, -1};
        }

        int end  = nums.length - 1;
        for ( ; end >= start; end--) {
            if (target == nums[end]) {
                break;
            }
        }

        result[1] = end;
        return result;
    }

    /**
     * 利用二分法来求排序数组指定元素区间
     * 时间复杂度 O(log n)
     * @param nums 排序数组
     * @param target 目标值
     * @return 元素区间起始、终止索引集合，若不存在则返回 {1, -1}
     */
    private static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[]{-1, -1};
        }

        int[] result = new int[2];
        int start = 0, end = nums.length - 1;
        // 找到第一个位置，一直抛弃右边的值，同时移动左边的值
        // 当 start > end 刚好找到第一个值位置
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (start < nums.length && nums[start] == target) {
            result[0] = start;
        } else {
            return new int[]{-1, -1};
        }

        // 与上一种二分法的判断条件刚好相反
        end = nums.length -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        result[1] = end;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 4};
        System.out.println(Arrays.toString(searchRange(nums, 5)));
        System.out.println(Arrays.toString(searchRangeTest(nums, 5)));
    }
}
