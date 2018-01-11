package com.qg.fangrui.medium.code016;

import java.util.Arrays;

/**
 * 3 Sum Closest
 * @author FunriLy
 * Created by FunriLy on 2018/1/11.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 查找最与目标值接近的三数之和
     * @param nums 给定数组
     * @param target 目标值
     * @return 最接近目标值的三数之和
     */
    private static int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        // 记录三数之和与目标值之间的差距
        int diff = Integer.MAX_VALUE;
        int minCapacity = 2;
        if (nums == null || nums.length <= minCapacity) {
            return 0;
        }

        Arrays.sort(nums);
        int n = nums.length;
        for (int i=n-1; i>1; i--) {
            if (i!=n-1 && nums[i] == nums[i+1]) {
                continue;
            }

            int start = 0, end = i-1;
            while (start < end) {
                int closeSum = nums[start] + nums[end] + nums[i];
                int temp = Math.abs(closeSum - target);
                if (temp == 0) {
                    // 刚好三数之和与目标值相等
                    return target;
                } else if (temp < diff) {
                    // 更新数据
                    diff = temp;
                    sum = closeSum;
                }

                if (closeSum < target) {
                    start++;
                } else {
                    end--;
                }
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0,5,-1,-2,4,-1,0,-3,4,-5}, 1));
    }
}
