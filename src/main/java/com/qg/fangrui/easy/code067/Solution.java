package com.qg.fangrui.easy.code067;

/**
 * Add Binary
 * @author FunriLy
 * Created by FunriLy on 2018/1/20.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 将两个二进制字符串相加
     * @param a 二进制字符串1
     * @param b 二进制字符串2
     * @return 二进制字符串之和
     */
    private static String addBinary(String a, String b) {
        int flag = 0, an = a.length()-1, bn = b.length()-1;
        StringBuilder str = new StringBuilder();

        while (an >= 0 && bn >= 0) {
            int temp = a.charAt(an) - '0' + b.charAt(bn) - '0' + flag;
            flag = temp / 2;
            str.append(temp %2);
            an--;
            bn--;
        }
        while (an >= 0) {
            int temp = a.charAt(an) - '0' + flag;
            flag = temp / 2;
            str.append(temp % 2);
            an--;
        }
        while (bn >= 0) {
            int temp = b.charAt(bn) - '0' + flag;
            flag = temp / 2;
            str.append(temp % 2);
            bn--;
        }
        if (flag == 1) {
            str.append(flag);
        }
        return str.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }
}
