package com.qg.fangrui.easy.code014;

/**
 * Longest Common Prefix
 * @author FunriLy
 * Created by FunriLy on 2018/1/7.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 求出字符串数组的公共前缀字符串
     * @param strs 给定字符串数组
     * @return 公共前缀字符串
     */
    private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            // indexOf() == 0 是求出前缀 pre 在当前字符串的首部
            while (strs[i].indexOf(pre) != 0) {
                // 若不在首部，则去掉 pre 最后一个字符并再次验证
                pre = pre.substring(0, pre.length() - 1);
            }
            i++;
        }
        return pre;
    }

    public static void main(String[] args) {
        String[] strs = {"abcd", "abce", "abcf", "abcdfg"};
        System.out.println(longestCommonPrefix(strs));
    }
}
