package com.qg.fangrui.medium.code003;

/**
 * Longest Substring Without Repeating Characters
 * @author FunriLy
 * Created by FunriLy on 2018/1/9.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 找出字符串中最长不同子串长度
     * @param s 给定字符串
     * @return 所找到子串长度
     */
    private static int lengthOfLongestSubstring(String s) {
        int[] arr = new int[256];
        int result = 0;
        for (int i=0, j=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            arr[ch]++;
            while (arr[ch] > 1) {
                arr[s.charAt(j++)]--;
            }
            result = Math.max( i - j + 1, result);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("abcd"));
    }
}
