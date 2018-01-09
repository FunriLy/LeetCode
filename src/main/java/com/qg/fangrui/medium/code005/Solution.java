package com.qg.fangrui.medium.code005;

/**
 * Longest Palindromic Substring
 * @author FunriLy
 * Created by FunriLy on 2018/1/9.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 利用动态规划算法求最长回文子序列
     * 注意 : 该方法需要构造额外的（n^2）的空间，会导致在 LeetCode 上运行失败
     * @param s 给定字符串
     * @return 最长回文子序列
     */
    private static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        String str = String.valueOf(s.charAt(0));
        int maxLen = 1;
        int len = s.length();
        int[][] table = new int[len][len];
        for (int i=0; i<len-1; i++) {
            table[i][i] = 1;
            if (s.charAt(i) == s.charAt(i+1)) {
                table[i][i+1] = 1;
                str = s.substring(i, i+2);
                maxLen = 2;
            }
        }
        table[len-1][len-1] = 1;

        for (int l=3; l<=len; l++) {
            for (int i=0; i<=len-l; i++) {
                int j = l + i-1;
                if (s.charAt(i) == s.charAt(j)) {
                    table[i][j] = table[i + 1][j - 1];
                    if (table[i][j] == 1 && l > maxLen) {
                        str = s.substring(i, j+1);
                        maxLen = l;
                    }

                } else {
                    table[i][j] = 0;
                }
            }
        }

        return str;
    }

    /**
     * 由给定两端向字符串左右扩展，构造出回文子序列
     * @param s 给定字符串
     * @param begin 回文序列起点
     * @param end 回文序列终点
     * @return 新构造的回文序列
     */
    private static String expandFromCenter(String s, int begin, int end) {
        while (begin>=0 && end<s.length() && s.charAt(begin)==s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin+1, end);
    }

    /**
     * 利用中间扩展的方法求最长回文子序列
     * @param s 给定字符串
     * @return 最长子序列
     */
    private static String longestPalindromeTwo(String s) {
        if (s == null || s.length()<=1) {
            return s;
        }

        String str = s.substring(0, 1);
        for (int i=1; i<s.length(); i++) {
            String temp;
            temp = expandFromCenter(s, i, i);
            if (temp.length() > str.length()) {
                str = temp;
            }

            temp = expandFromCenter(s, i, i+1);
            if (temp.length() > str.length()) {
                str = temp;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcbf"));
        System.out.println(longestPalindromeTwo("abcbf"));
    }
}
