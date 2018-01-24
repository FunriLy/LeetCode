package com.qg.fangrui.medium.code075;

import java.util.Arrays;

/**
 * Sort Colors
 * @author FunriLy
 * Created by FunriLy on 2018/1/24.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 三色旗问题 : 数组排序(排名在39%左右)
     * 计数排序算法
     * 参考资料 http://blog.csdn.net/linhuanmars/article/details/24286349
     * @param nums 数组
     */
    private static void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 标记最后一个 0 和 1 的索引标签
        int indexZero = 0, indexOne = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = 2;
                nums[indexOne++] = 1;
                nums[indexZero++] = 0;
            } else if (nums[i] == 1) {
                nums[i] = 2;
                nums[indexOne++] = 1;
            }
        }
    }

    /**
     * 交换数组中两个元素的位置
     * @param nums 数组
     * @param a 索引1
     * @param b 索引2
     */
    private static void  swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    /**
     * 三色旗问题 : 数组排序(排名在39%左右)
     * 采用类似于快排的算法
     * @param nums 数组
     */
    private static void sortColorsOther(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // low:最后一个0的索引
        // mid:当前操作元素，也是最后一个1的下一个元素
        // high:第一个2的索引
        int low = 0, mid = 0, high = nums.length -1;
        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, high);
                    high--;
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sortColorsOther(nums2);
        System.out.println(Arrays.toString(nums2));
    }
}
