package com.qg.fangrui.medium.code090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Subsets II
 * @author FunriLy
 * Created by FunriLy on 2018/1/28.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 利用递归求解数组集合
     * @param result 存储结果的集合
     * @param list 当前可能集合
     * @param nums 数组
     * @param start 当前处理索引
     */
    private static void dfs(List<List<Integer>> result, List<Integer> list,
                            int[] nums, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(result, list, nums, i + 1);
            list.remove(list.size() - 1);
            // [1, 2, 2] : 以当前start=0、i=1为例，因为第一个2已经处理了，就无需处理第二个2
            // 所以执行i++操作
            while (i+1 < nums.length && nums[i] == nums[i+1]) {
                i++;
            }
        }
    }

    /**
     * 对可能含有重复元素的数组取其集合
     * @param nums 可能含有重复元素的数组
     * @return 数组集合
     */
    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        dfs(result, list, nums, 0);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = subsetsWithDup(new int[]{1, 2, 2});
        result.forEach(System.out::println);
    }
}
