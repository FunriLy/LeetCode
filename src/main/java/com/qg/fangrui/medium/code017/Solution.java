package com.qg.fangrui.medium.code017;

import java.util.ArrayList;
import java.util.List;

/**
 * Letter Combinations of a Phone Number
 * @author FunriLy
 * Created by FunriLy on 2018/1/11.
 * From small beginnings comes great things.
 */
public class Solution {

    private static final String[] KEYBOARD = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * 递归实现
     * @param digits 给定字符串
     * @return 返回符合规则的字符串集合
     */
    private static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits==null || digits.isEmpty()) {
            return result;
        }
        StringBuilder str = new StringBuilder();
        dfsGetStr(result, digits, 0, str);
        return result;
    }

    /**
     * 递归求解(很巧妙的一种方法)
     * @param result 结果集合
     * @param digits 给定字符串
     * @param index 当前索引
     * @param str 当前字符串
     */
    private static void dfsGetStr(List<String> result, String digits, int index, StringBuilder str) {
        if (index >= digits.length()) {
            // 如果已经达到给定字符串长度
            result.add(str.toString());
        } else {
            // 计算当前索引号
            int num = digits.charAt(index) - '0';
            // 找到当前索引下的字符串，根据其每一个字符进行组合
            for (int i=0; i<KEYBOARD[num].length(); i++) {
                // 将字符组合到容器中
                str.append(KEYBOARD[num].charAt(i));
                // 在当前模式下递归求解
                dfsGetStr(result, digits, index+1, str);
                // 去掉加上的字符，在利用较少资源的情况下，防止同一个容器对其他情况的影响
                str.deleteCharAt(str.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<String> result = letterCombinations("23");
        for (String str : result) {
            System.out.print(str + " ");
        }
    }
}
