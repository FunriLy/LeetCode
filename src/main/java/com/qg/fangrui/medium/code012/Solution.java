package com.qg.fangrui.medium.code012;

/**
 * Integer to Roman
 * @author FunriLy
 * Created by FunriLy on 2018/1/10.
 * From small beginnings comes great things.
 */
public class Solution {

    /*
    参考资料 http://www.cnblogs.com/grandyang/p/4123374.html
    重点讲所有组合可能求出
     */

    /**
     * 利用贪婪算法+查表求出罗马数字
     * @param num 给定整数
     * @return 转换后结果
     */
    private static String intToRoman(int num) {
        int minNum = 1, maxNum = 3999;
        if (num < minNum || num > maxNum) {
            return null;
        }

        /*
        这里使用String会导致超时
         */

        StringBuilder str = new StringBuilder("");
        String [] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int [] value = {1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   1};

        for(int i=0;num!=0;i++){
            while (num >= value[i]) {
                num -= value[i];
                str.append(symbol[i]);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(9));
    }
}
