package com.qg.fangrui.easy.code020;

import java.util.Stack;

/**
 * Valid Parentheses
 * @author FunriLy
 * Created by FunriLy on 2018/1/7.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 判断一个字符串是否是符号对称
     * @param s 给定字符串
     * @return 若对称则返回 true 否则返回 false
     */
    private static boolean isValid(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] parentheses = s.toCharArray();

        for (int i=0; i<s.length(); i++) {
            if (parentheses[i] == '(' || parentheses[i] == '{' || parentheses[i] == '[') {
                stack.add(parentheses[i]);
            } else if (parentheses[i] == ')') {
                // 判断栈是否为空是为了避免 "))"
                if (stack.size() == 0 || stack.pop() != '(') {
                    return false;
                }
            } else if (parentheses[i] == '}') {
                if (stack.size() == 0 || stack.pop() != '{') {
                    return false;
                }
            } else if (parentheses[i] == ']') {
                if (stack.size() == 0 || stack.pop() != '[') {
                    return false;
                }
            } else {
                return false;
            }
        }
        // 检查栈容量是为了避免类似于 "(("
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("(("));
        System.out.println(isValid("))"));
    }
}
