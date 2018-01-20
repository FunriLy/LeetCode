package com.qg.fangrui.easy.code088;

import java.util.Arrays;

/**
 * Merge Sorted Array
 * @author FunriLy
 * Created by FunriLy on 2018/1/20.
 * From small beginnings comes great things.
 */
public class Solution {

    // todo:暂未找到更加高效解法

    /**
     * 排序两个有序数组(太慢)
     * @param nums1 有序数组1
     * @param m 数组个数
     * @param nums2 有序数组2
     * @param n 数组个数
     */
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }

        int index1 = m-1;
        int index2 = n-1;
        int len = m+n-1;

        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[len--] = nums1[index1--];
            } else {
                nums1[len--] = nums2[index2--];
            }
        }

        while (index2 >= 0) {
            nums1[len--] = nums2[index2--];
        }
    }

    /**
     * 排序两个有序数组(太慢)
     * @param nums1 有序数组1
     * @param m 数组个数
     * @param nums2 有序数组2
     * @param n 数组个数
     */
    private static void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
