package com.qg.fangrui.easy.code125;

/**
 * Valid Palindrome
 * @author FunriLy
 * Created by FunriLy on 2018/1/30.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 检查一个字符是否是在 a-z 或者 0-9 之间
     * @param ch 给定字符
     * @return 若字符处于 a-z 之间返回 true 否则返回 false
     */
    private static boolean isLetterOrNumber(Character ch) {
        boolean isLetter = ch >= 'a' && ch <= 'z';
        boolean isNumber = ch >= '0' && ch <= '9';
        return isLetter || isNumber;
    }

    /**
     * 判断给定字符串是不是回文字符串
     * @param s 字符串
     * @return 若字符串为回文字符串返回 true 否则返回 false
     */
    private static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        String str = s.toLowerCase().replaceAll(" ", "");
        int start = 0, end = str.length() - 1;
        while (start <= end) {
            while (start <= end && !isLetterOrNumber(str.charAt(start))) {
                start++;
            }
            while (end >= 0 && !isLetterOrNumber(str.charAt(end))) {
                end--;
            }
            if (start <= end && str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("."));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }
}
