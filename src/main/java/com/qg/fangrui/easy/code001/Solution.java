package com.qg.fangrui.easy.code001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 * @author FunriLy
 * Created by FunriLy on 2018/1/6.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 利用两层循环求解
     * @param nums 给定数组
     * @param target 给定目标值
     * @return 若找到返回新数组，否则返回null
     */
    private int[] twoSumOne(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    /**
     * 利用 hash 表求解
     * @param nums 给定数组
     * @param target 给定目标值
     * @return 若找到返回新数组，否则返回null
     */
    private int[] twoSumTwo(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 2, 4};
        int target = 6;
        // 答案为[1, 2]
        System.out.println(Arrays.toString(solution.twoSumOne(nums, target)));
        System.out.println(Arrays.toString(solution.twoSumTwo(nums, target)));
    }
}
