package com.qg.fangrui.medium.code022;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate Parentheses
 * @author FunriLy
 * Created by FunriLy on 2018/1/12.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 检查当前字符串是否符合规则
     * @param str 当前字符串
     * @return 若符合规则返回 true 否则返回 false
     */
    private static boolean isTrue(StringBuilder str) {
        int count = 0;
        for (int i=0; i<str.length(); i++) {
            char temp = str.charAt(i);
            if (temp == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 递归构造字符串
     * @param result 存储字符串的结果集
     * @param leftNum 左括号剩余个数
     * @param rightNum 右括号剩余个数
     * @param str 当前字符串
     */
    private static void structure(List<String> result, int leftNum, int rightNum, StringBuilder str) {
        if (leftNum == 0 && rightNum == 0) {
            result.add(str.toString());
            return;
        }

        if (leftNum > 0) {
            str.append("(");
            // 若推荐左括号不需要进行减去操作
            structure(result, leftNum-1, rightNum, str);
            str.deleteCharAt(str.length() - 1);
        }

        if (rightNum > 0) {
            str.append(")");
            // 减枝操作，减轻运算量
            if (isTrue(str)) {
                structure(result, leftNum, rightNum - 1, str);
            }
            str.deleteCharAt(str.length() - 1);
        }
    }

    /**
     * 根据所给数字构造遍历对称的字符串
     * @param n 给定数字
     * @return 字符串集
     */
    private static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        StringBuilder str = new StringBuilder();
        structure(result, n, n, str);
        return result;
    }

    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        for (String str : result) {
            System.out.println(str);
        }
    }
}
