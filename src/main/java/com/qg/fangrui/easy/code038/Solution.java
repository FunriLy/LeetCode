package com.qg.fangrui.easy.code038;

/**
 * Count and Say
 * @author FunriLy
 * Created by FunriLy on 2018/1/8.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 数数和计数
     * @param n 给定数字
     * @return 转化后字符串
     */
    private static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String str = countAndSay(n-1) + "*";
        char[] strCh = str.toCharArray();
        int count = 1;
        String s = "";
        for (int i=0; i<strCh.length-1; i++) {
            if (strCh[i] == strCh[i+1]) {
                count++;
            } else {
                s = s + count + strCh[i];
                count = 1;
            }
        }
        return s;
    }

    /*
    此题规则难懂，但思路简单
     */

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
        System.out.println(countAndSay(7));
        System.out.println(countAndSay(8));
    }
}
