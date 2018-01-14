package com.qg.fangrui.medium.code029;

/**
 * Divide Two Integers
 * @author FunriLy
 * Created by FunriLy on 2018/1/14.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 不使用乘法、除法和取余运算来实现整数除法
     * 就是说需要使用位运算
     * @param dividend 被除数
     * @param divisor 除数
     * @return 商
     */
    private static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            // 若除数为 0
            return Integer.MAX_VALUE;
        } else if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return ~dividend;
        }
        int result = 0;
        // 注意这里需要先转化为 long 之后再取绝对值
        long tempDivisor = Math.abs((long) divisor);
        long tempDividend = Math.abs((long) dividend);
        while (tempDividend >= tempDivisor) {
            // 若被除数大于除数
            int count = 0;
            // 左移操作<<相当于对一个数乘以2
            while (tempDividend >= (tempDivisor << count)) {
                count++;
            }
            // 累计结果
            result += 1<<(count-1);

            // 重新计算被除数
            tempDividend -= tempDivisor<<(count-1);

        }

        boolean left = dividend>0 && divisor>0;
        boolean right = dividend<0 && divisor<0;
        if (left || right) {
            return  result;
        } else {
            return -result;
        }
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 1));
        System.out.println(divide(-2147483648, 2));
    }
}
