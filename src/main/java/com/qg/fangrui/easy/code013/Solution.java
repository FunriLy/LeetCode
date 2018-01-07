package com.qg.fangrui.easy.code013;

/**
 * Roman to Integer
 * @author FunriLy
 * Created by FunriLy on 2018/1/7.
 * From small beginnings comes great things.
 */
public class Solution {

    /*
    罗马数字规则:
    罗马数字采用七个罗马字母作数字、即Ⅰ（1）、X（10）、C（100）、M（1000）、V（5）、L（50）、D（500）。
    1、相同的数字连写，所表示的数等于这些数字相加得到的数，例如：III = 3
    2、小的数字在大的数字右边，所表示的数等于这些数字相加得到的数，例如：VIII = 8
    3、小的数字，限于（I、X和C）在大的数字左边，所表示的数等于大数减去小数所得的数，例如：IV = 4
    4、正常使用时，连续的数字重复不得超过三次
    5、在一个数的上面画横线，表示这个数扩大1000倍（本题只考虑3999以内的数，所以用不到这条规则）
     */

    /**
     * 将一个罗马数字字符转换为整数
     * @param ch 给定罗马数字字符
     * @return 转换后的结果
     */
    private static int charToInt(char ch) {
        int data = 0;

        switch (ch) {
            case 'I' :
                data += 1;
                break;
            case 'X' :
                data += 10;
                break;
            case 'C' :
                data += 100;
                break;
            case 'M' :
                data += 1000;
                break;
            case 'V' :
                data += 5;
                break;
            case 'L' :
                data += 50;
                break;
            case 'D' :
                data += 500;
                break;
            default:
                data += 0;
        }

        return data;
    }

    /**
     * 将罗马数字转换为整数(范围 : 1-3999)
     * 注意 : 罗马数是从左往右读
     * @param s 罗马数字字符串
     * @return 转换后的结果
     */
    private static int romanToInt(String s) {
        int pre, cur;
        if (s == null || s.length() <= 0) {
            return 0;
        }

        int total = charToInt(s.charAt(0));

        for (int i=1; i<s.length(); i++) {
            pre = charToInt(s.charAt(i-1));
            cur = charToInt(s.charAt(i));

            if (cur <= pre) {
                total += cur;
            } else {
                // 这里 pre*2 因为适用规则3外，还要求将上一步的动作减去
                total = total + cur - pre * 2;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        String s = "MCMLXXX";
        // 1980
        System.out.println(romanToInt(s));
    }
}
