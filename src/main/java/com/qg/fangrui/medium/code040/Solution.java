package com.qg.fangrui.medium.code040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum II
 * @author FunriLy
 * Created by FunriLy on 2018/1/16.
 * From small beginnings comes great things.
 */
public class Solution {


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

            // 只对于第一次得到这个数进行递归，接下来就跳过这个元素
            if (i != start  && nums[i] == nums[i-1]) {
                continue;
            }

            // 若当前值小于目标值，将当前的值加入储备数组
            numList.add(nums[i]);
            // 递归搜索
            combination(result, numList, i+1, target-nums[i], nums);
            // 移除当前值
            //numList.remove(nums[i]); 由于允许存在相同的值，这种写法错误
            numList.remove(numList.size() - 1);
        }
    }

    /**
     * 找出数组中能够构成目标值的所有组合(不允许重复使用元素)
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
        Arrays.sort(candidates);
        combination(result, new ArrayList<>(), 0, target, candidates);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum(new int[]{1, 1, 1, 2, 4}, 5);
        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }
}
