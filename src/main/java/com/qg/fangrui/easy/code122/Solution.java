package com.qg.fangrui.easy.code122;

/**
 * Best Time to Buy and Sell Stock II
 * @author FunriLy
 * Created by FunriLy on 2018/1/30.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 最佳时间买入卖出股票（多次买卖）
     * @param prices 股票价格数组
     * @return 最终利润
     */
    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length, max = 0;
        for (int i=1; i<len; i++) {
            int diff = prices[i] - prices[i-1];
            if (diff > 0) {
                max += diff;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 4, 6}));
    }
}
