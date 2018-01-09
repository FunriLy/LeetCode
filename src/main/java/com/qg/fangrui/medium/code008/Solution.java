package com.qg.fangrui.medium.code008;

/**
 * String to Integer (atoi)
 * @author FunriLy
 * Created by FunriLy on 2018/1/10.
 * From small beginnings comes great things.
 */
public class Solution {

    /*
    此题思路来源于《剑指 Offer》，感觉效率较低
     */

    /**
     * 判断一个字符是否是 0-9 的字符
     * @param ch 给定字符
     * @return 若给定字符的 0-9 返回true，否则返回false
     */
    private static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    /**
     * 将不带符号的字符串转化为整数
     * @param str 给定字符串
     * @param index 转换起始索引
     * @param minus 是否是负数
     * @return 转换后结果
     */
    private static int strtoInt(String str, int index, boolean minus) {
        int num = 11;
        int result;
        long temp = 0;

        while (index < str.length() && isDigit(str.charAt(index)) && index <= num) {
            temp = temp * 10 + (str.charAt(index) - '0');
            index++;
        }

        // 如果字符串过长超出可处理范围(11位内)
        if (index>num ||temp < 0) {
            return minus?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }

        if (minus) {
            result = temp>Integer.MAX_VALUE ? Integer.MIN_VALUE : (int) -temp;
        } else {
            result = temp>Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) temp;
        }
        return result;
    }

    private static int myAtoi(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }

        str = str.trim();

        char minus = '-';
        char plus = '+';
        char first = str.charAt(0);
        if (first == minus) {
            return strtoInt(str, 1, true);
        } else if (first == plus) {
            return strtoInt(str, 1, false);
        } else if (isDigit(first)) {
            return strtoInt(str, 0, false);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483648"));
    }
}
