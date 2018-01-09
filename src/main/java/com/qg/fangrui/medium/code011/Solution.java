package com.qg.fangrui.medium.code011;

/**
 * Container With Most Water
 * @author FunriLy
 * Created by FunriLy on 2018/1/10.
 * From small beginnings comes great things.
 */
public class Solution {

    // todo:可能会有更好的解法

    /**
     * 找到能够构造的最大容器的容量
     * @param height 构造数组
     * @return 最大容器容量
     */
    private static int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int maxArea = 0;
        while (left<right) {
            int temp = (right - left) * Math.min(height[left], height[right]);
            // emmmmmmm 如果换用三元式会导致超时……………………
            // maxArea = (maxArea>=temp ? maxArea : temp);
            if (maxArea < temp) {
                maxArea = temp;
            }
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{10, 1, 2, 3, 4, 5, 6, 7, 11}));
    }
}
