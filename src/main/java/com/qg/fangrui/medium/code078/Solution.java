package com.qg.fangrui.medium.code078;

import java.util.ArrayList;
import java.util.List;

/**
 * Subsets
 * @author FunriLy
 * Created by FunriLy on 2018/1/25.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 递归求当前数组范围的子集合
     * @param result 存储集合的结果
     * @param list 当前集合
     * @param nums 给定数组
     * @param k 起始索引
     */
    private static void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int k) {
        result.add(new ArrayList<>(list));
        for (int i=k; i<nums.length; i++) {
            list.add(nums[i]);
            dfs(result, list, nums, i+1);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 递归求解数组的子集合
     * @param nums 给定数组
     * @return 数组的子集合
     */
    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        dfs(result, list, nums, 0);
        return result;
    }

    /**
     * 非递归求解数组的子集合
     * @param nums 给定数组
     * @return 数组的子集合
     */
    private static List<List<Integer>> subsetsTwo(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        result.add(new ArrayList<>());

        for (int num : nums) {
            int size = result.size();
            for (int i=0; i<size; i++) {
                // 逐一取出中间结果集
                List<Integer> list = new ArrayList<>(result.get(i));
                // 将 num 放入中间结果集
                list.add(num);
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("================");
        List<List<Integer>> result1 = subsets(nums);
        result1.forEach(System.out::println);
        System.out.println("================");
        List<List<Integer>> result2 = subsetsTwo(nums);
        result2.forEach(System.out::println);
    }
}
