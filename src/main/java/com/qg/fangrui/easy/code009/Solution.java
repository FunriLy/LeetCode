package com.qg.fangrui.easy.code009;

/**
 * Palindrome Number
 * @author FunriLy
 * Created by FunriLy on 2018/1/7.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 验证整数是否为回文数
     * @param x 给定整数
     * @return 若整数是回文数返回 true 否则返回 false
     */
    private static boolean isPalindrome(int x) {
        int ten = 10, medium = 2;
        if (x < 0) {
            // 若给定整数是负数，返回 false
            return false;
        }
        // 计算出位数 num
        int div = 1;
        int num = 1;
        while (div <= x/ten) {
            num++;
            div *= 10;
        }

        for(int i=0; i<num/medium; i++) {
            if (x/div != x%10) {
                return false;
            }
            // 去掉前后各一位数
            x = (x % div) / 10;
            // 注意这里是除以 100
            div /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        int test = 1000021;
        System.out.println(isPalindrome(test));
    }
}
