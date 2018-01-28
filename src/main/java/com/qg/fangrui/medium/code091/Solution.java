package com.qg.fangrui.medium.code091;

/**
 * Decode Ways
 * @author FunriLy
 * Created by FunriLy on 2018/1/28.
 * From small beginnings comes great things.
 */
public class Solution {

    /*
    参考资料 : https://segmentfault.com/a/1190000003813921
     */

    /**
     * 求解给定字符串转化为字母的解法数量
     * @param s 给定字符串
     * @return 解法数量
     */
    private static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] nums = new int[s.length() + 1];
        // 这里设置为1，是第一种方法：全部独立开来
        nums[0] = 1;
        nums[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i=2; i<nums.length; i++) {
            // 如果字符串的第i-1位和第i位能组成一个10到26的数字，说明我们可以在第i-2位的解码方法上继续解码
            if(Integer.parseInt(s.substring(i-2, i)) <= 26 && Integer.parseInt(s.substring(i-2, i)) >= 10){
                nums[i] += nums[i - 2];
            }
            // 如果字符串的第i-1位和第i位不能组成有效二位数字，在第i-1位的解码方法上继续解码
            if(Integer.parseInt(s.substring(i-1, i)) != 0){
                nums[i] += nums[i - 1];
            }
        }
        return nums[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("123"));
    }
}
