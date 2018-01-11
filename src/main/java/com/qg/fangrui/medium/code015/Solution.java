package com.qg.fangrui.medium.code015;

import java.util.*;

/**
 * 3 Sum
 * @author FunriLy
 * Created by FunriLy on 2018/1/11.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 查找两个数与给定的数之和为 0
     * @param nums 查找数组
     * @param start 起始索引
     * @param end 终止索引
     * @param target 目标值
     * @param result 结果集
     */
    private static void findTwoSum(int[] nums, int start, int end, int target, List<List<Integer>> result) {
        while (start < end) {
            int temp = nums[start] + nums[end] + target;
            // 要考虑答案不止一个的可能性
            if (temp == 0) {
                List<Integer> answer = new ArrayList<>();
                answer.add(nums[start]);
                answer.add(nums[end]);
                answer.add(target);
                result.add(answer);
                // 检查下一个数是否与当前搜索数组两端相同，防止插入相同数据到结果集中
                while (start<end && nums[start]==nums[start+1]) {
                    start++;
                }
                while (start<end && nums[end]==nums[end-1]) {
                    end--;
                }
                // 缩小搜索范围
                start++;
                end--;
            } else if (temp < 0) {
                start++;
            } else {
                end--;
            }
        }
    }

    /**
     * 查找出数组中三个数之和为0的集合
     * @param nums 给定数组
     * @return 查找到的集合
     */
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int minCapacity = 2;
        if (nums == null || nums.length <= minCapacity) {
            return result;
        }
        // 递增排序
        Arrays.sort(nums);
        int n = nums.length;
        // 从尾扫描到正数第三个数
        for (int i=n-1; i>1; i--) {
            if (i!=n-1 && nums[i] == nums[i+1]) {
                continue;
            }
            findTwoSum(nums, 0, i-1, nums[i], result);
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }
}
