package com.qg.fangrui.medium.code039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum
 * @author FunriLy
 * Created by FunriLy on 2018/1/16.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 对数组进行预处理(排序并去掉重复数字)
     * @param candidatas 给定数组
     * @return 处理后的新数组
     */
    private static int[] dealSithTheArray(int[] candidatas) {
        Arrays.sort(candidatas);

        int index = 0;
        for (int i=0; i<candidatas.length; i++) {
            // 去除重复数字
            if (candidatas[i] != candidatas[index]) {
                candidatas[++index] = candidatas[i];
            }
        }

        int[] nums = new int[index+1];
        System.arraycopy(candidatas, 0, nums, 0, index+1);

        return nums;
    }

    /**
     * 递归判断当前组合是否合适
     * @param result 所有组合的集合
     * @param numList 当前组合
     * @param start 开始索引
     * @param target 目标值
     * @param nums 给定数组
     */
    private static void combination(List<List<Integer>> result,
                             List<Integer> numList,
                             int start, int target, int[] nums) {
        if (target == 0) {
            // 这里一定要构造一个新的集合
            result.add(new ArrayList<>(numList));
            return;
        }

        for (int i=start; i<nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            // 若当前值小于目标值，将当前的值加入储备数组
            numList.add(nums[i]);
            // 递归搜索
            combination(result, numList, i, target-nums[i], nums);
            // 移除当前值
            //numList.remove(nums[i]); 由于允许存在相同的值，这种写法错误
            numList.remove(numList.size() - 1);
        }
    }

    /**
     * 找出数组中能够构成目标值的所有组合(允许重复使用元素)
     * @param candidates 给定数组
     * @param target 目标值
     * @return 所有可能组合
     */
    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        // 先对数据进行处理
        int[] nums = dealSithTheArray(candidates);
        combination(result, new ArrayList<>(), 0, target, nums);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }
}
