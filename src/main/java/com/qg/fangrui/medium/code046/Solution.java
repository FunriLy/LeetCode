package com.qg.fangrui.medium.code046;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations
 * @author FunriLy
 * Created by FunriLy on 2018/1/17.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 查找给定数组不同组合方式
     * @param result 结果集合
     * @param nums 给定数组
     * @param index 当前索引
     */
    private static void  permutation(List<List<Integer>> result, int[] nums, int index) {
        if (index == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
        } else {
            int temp;
            for (int i=index; i<nums.length; i++) {
                temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;

                permutation(result, nums, index+1);

                temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
            }
        }
    }

    /**
     * 由给定(不重复)数组找出其不同组合
     * 参考资料 《剑指 Offer》 字符串的排序 一章
     * @param nums 给定数组
     * @return 不同组合的集合
     */
    private  static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return result;
        }
        permutation(result, nums, 0);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);

        for(List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }
}
