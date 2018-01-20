package com.qg.fangrui.easy.code069;

/**
 * Sqrt(x)
 * @author FunriLy
 * Created by FunriLy on 2018/1/20.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 实现 sqrt 函数(对于结果取整数)
     * 对于一个非负数n，它的平方根不会小于大于（n/2+1）
     * @param x 给定非负整数
     * @return 平方根
     */
    private static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        long start = 0, end = x/2+1;
        while (start <= end) {
            long mid = (start + end) / 2;
            long sqrt = mid * mid;
            if (sqrt == x) {
                return (int) mid;
            } else if (sqrt < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return (int) end;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
