package com.qg.fangrui.easy.code007;

/**
 * Reverse Integer
 * @author FunriLy
 * Created by FunriLy on 2018/1/7.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 翻转整数
     * @param x 给定32位内整数
     * @return 翻转整数，若大于上限或者小于上限，返回0；否则返回翻转后的整数
     */
    private static int reverseOne(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) ? 0 : (int) result;
    }

    /**
     * 翻转整数
     * @param x 给定32位内整数
     * @return 翻转整数，若大于上限或者小于上限，返回0；否则返回翻转后的整数
     */
    private static int reverseTwo(int x) {
        int result = 0;
        while (x != 0) {
            /*
            采用中间变量翻转整数，若发生溢出现象，则中间变量恢复不了原值
             */
            int temp = result * 10 + x % 10;
            if (temp / 10 != result) {
                return 0;
            }
            result = temp;
            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int x = 123;
        System.out.println(reverseOne(x));
        System.out.println(reverseTwo(x));

        x = 1000000009;
        System.out.println(reverseOne(x));
        System.out.println(reverseTwo(x));
    }
}
