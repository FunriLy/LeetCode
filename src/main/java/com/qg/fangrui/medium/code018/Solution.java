package com.qg.fangrui.medium.code018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4 Sum
 * @author FunriLy
 * Created by FunriLy on 2018/1/12.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 找出两数之和为目标值的集合
     * @param result 存储集合
     * @param nums 给定数组
     * @param start 起始索引
     * @param end 终止索引
     * @param target 目标值
     * @param num1 参数1
     * @param num2 参数2
     */
    private static void findTwoSum(List<List<Integer>> result, int[] nums,
                                   int start, int end, int target, int num1, int num2) {
        while (start < end) {
            int temp = nums[start] + nums[end] + num1 + num2;
            if (target == temp) {
                List<Integer> list = new ArrayList<>();
                list.add(num1);
                list.add(num2);
                list.add(nums[start]);
                list.add(nums[end]);
                result.add(list);

                while (start < end && nums[start] == nums[start+1]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end-1]) {
                    end--;
                }
                start++;
                end--;
            } else if (target > temp) {
                start++;
            } else {
                end--;
            }
        }
    }

    /**
     * 找出四个数之和为目标值的集合
     * @param nums 给定数组
     * @param target 目标值
     * @return 符合条件的集合
     */
    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int minCapacity = 3;
        if (nums == null || nums.length <= minCapacity) {
            return result;
        }
        // 排序
        Arrays.sort(nums);
        int len = nums.length, intervalThree = 3, intervalTwo = 2;
        for (int i=0; i<len-intervalThree; i++) {
            if (i!=0 && nums[i] == nums[i-1]) {
                // 第一个数与上一个数相同
                continue;
            }

            // 固定第二个数
            for (int j=i+1; j<len-intervalTwo; j++) {
                if (j>i+1 && nums[j] == nums[j-1]) {
                    continue;
                }

                findTwoSum(result, nums, j+1, len-1, target, nums[i], nums[j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> result = fourSum(nums, 0);
        result.forEach(System.out::println);
    }
}
