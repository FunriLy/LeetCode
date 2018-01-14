package com.qg.fangrui.medium.code031;

import java.util.Arrays;

/**
 * Next Permutation
 * @author FunriLy
 * Created by FunriLy on 2018/1/14.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 交换数组中两个元素的位置
     * @param nums 给定数组
     * @param i 元素位置1
     * @param j 元素位置2
     */
    private static void  swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 查找下一个排序的数组
     * 参考资料 http://www.cnblogs.com/grandyang/p/4428207.html
     * @param nums 给定数组
     */
    private static void nextPermutation(int[] nums) {
        int n = nums.length;
        for (int i=n-2; i>=0; i--) {
            // 从数组尾部开始扫描，找到第一个小于其后一个元素的元素，称为目标值
            if (nums[i+1] > nums[i]) {
                // 再次从尾部开始扫描，找到第一个比目标元素大的元素
                int j=n-1;
                for ( ; j>=1; j--) {
                    if (nums[j] > nums[i]) {
                        break;
                    }
                }
                // 交换两个元素的位置
                swap(nums, i, j);
                // 目标值之后的元素全部反向并退出
                for (int start=i+1, end = n-1; start < end; start++, end--) {
                    swap(nums, start, end);
                }
                return;
            }
        }
        // 若给定数组按照从大到小排序，则将其反转为从小到大排序
        for (int start=0, end = n-1; start < end; start++, end--) {
            swap(nums, start, end);
        }
    }

    public static void main(String[] args) {
        int[] nums0 = {3, 2, 1};
        nextPermutation(nums0);
        System.out.println(Arrays.toString(nums0));

        int[] nums1 = {1, 3, 2};
        nextPermutation(nums1);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {1, 2, 3};
        nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = {1, 1, 5};
        nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3));
    }
}
