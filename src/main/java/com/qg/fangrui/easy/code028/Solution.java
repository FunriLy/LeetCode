package com.qg.fangrui.easy.code028;

/**
 * Implement strStr()
 * @author FunriLy
 * Created by FunriLy on 2018/1/8.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 查找字符串中给定字符串的索引
     * @param haystack 原始字符串
     * @param needle 查找字符串
     * @return 若找到返回索引，若查找不到返回 -1
     */
    private static int strStr(String haystack, String needle) {
        int num = haystack.indexOf(needle);
        return num >= 0 ? num : -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
    }
}
