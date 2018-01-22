package com.qg.fangrui.medium.code055;

/**
 * Jump Game
 * @author FunriLy
 * Created by FunriLy on 2018/1/21.
 * From small beginnings comes great things.
 */
public class Solution {

    /*
    最开始我是看不懂题意…………
    求助于 https://discuss.leetcode.com/topic/4911/linear-and-simple-solution-in-c
     */

    /**
     * 利用贪心算法检查是否能够到达数组最后一个元素
     * @param nums 给定数组
     * @return 若能到达返回 true 否则返回 false
     */
    private static boolean canJump(int[] nums) {
        int reach = 0;
        int i = 0;
        for ( ; i < nums.length && i <= reach; i++) {
            reach = Math.max(reach, i + nums[i]);
        }
        return (i == nums.length);
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }
}
