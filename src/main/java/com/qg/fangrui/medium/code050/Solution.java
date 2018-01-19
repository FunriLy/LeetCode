package com.qg.fangrui.medium.code050;

/**
 * Pow(x, n)
 * @author FunriLy
 * Created by FunriLy on 2018/1/19.
 * From small beginnings comes great things.
 */
public class Solution {

    /*
    参考《剑指Offer》求数值的整数次方
     */

    /**
     * 判断两个 double 型数值是否相等
     * @param num1 数值1
     * @param num2 数值2
     * @return 若两个 double 数相等返回 true，否则返回 false
     */
    private static boolean equal(double num1, double num2) {
        double min = 0.000001;
        return (num1-num2 > -min) && (num1-num2 < min);
    }

    /**
     * 求一个数的整数方
     * 直接采用书中的方法会导致栈溢出，所以采用二分的方法来求解
     * @param base 底数
     * @param exponent 指数
     * @return 给定数的整数次方
     */
    private static double powerWithUnsignedExponent (double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        double half = powerWithUnsignedExponent(base, exponent/2);
        if(exponent % 2 == 0) {
            return half * half;
        } else {
            return base * half * half;
        }
    }

    /**
     * 求一个数的整数方
     * @param x 底数
     * @param n 指数
     * @return 给定数的整数次方
     */
    private static double myPow(double x, int n) {
        if (equal(x, 0.0) && n < 0) {
            return 0.0;
        }

        int absN = Math.abs(n);
        double result = powerWithUnsignedExponent(x, absN);
        if (n < 0) {
            result = 1.0 / result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.10000, 3));
    }
}
