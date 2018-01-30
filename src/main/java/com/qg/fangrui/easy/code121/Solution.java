package com.qg.fangrui.easy.code121;

/**
 * Best Time to Buy and Sell Stock
 * @author FunriLy
 * Created by FunriLy on 2018/1/30.
 * From small beginnings comes great things.
 */
public class Solution {

    /*
    比较简单的一道题，想复杂了……
    参考资料 : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/39062
     */

    /**
     * 求出数组数值差最大的区间的值
     * @param prices 数组
     * @return 区间两端数值之差
     */
    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = prices[0];
        int max = 0;
        for (int num : prices) {
            if (num > min) {
                max = Math.max(max, num - min);
            } else {
                min = num;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
