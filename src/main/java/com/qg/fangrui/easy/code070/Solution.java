package com.qg.fangrui.easy.code070;

/**
 * Climbing Stairs
 * @author FunriLy
 * Created by FunriLy on 2018/1/20.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 斐波那契数列
     * @param n 给定正整数索引
     * @return 相应的数列值
     */
    private static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int a = 1, b = 1;
        for (int i=2; i<=n; i++) {
            int temp = a+b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
