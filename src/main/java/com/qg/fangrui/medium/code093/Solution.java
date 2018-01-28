package com.qg.fangrui.medium.code093;

import java.util.ArrayList;
import java.util.List;

/**
 * Restore IP Addresses
 * @author FunriLy
 * Created by FunriLy on 2018/1/28.
 * From small beginnings comes great things.
 */
public class Solution {

    private static int minStringLen = 4;

    /**
     * 为 ip 地址加上一个分区
     * @param result 结果集合
     * @param index 当前处理分区数
     * @param str 当前ip地址
     * @param s 剩余字符串
     */
    private static void helper(List<String> result, int index, String str, String s) {
        if (index == minStringLen) {
            if ("".equals(s) || s.isEmpty()) {
                result.add(str);
            }
            return;
        }

        for (int i=1; i<minStringLen; i++) {
            if (s.length() < i) {
                break;
            }
            String temp = s.substring(0, i);
            Integer value = Integer.parseInt(temp);
            if (value > 255 || i != value.toString().length()) {
                // 第二个条件清除前缀为 0 的字符串，如 010
                continue;
            }
            // 每一次递归前都加上 "."
            helper(result, index+1, str + temp + (index == 3 ? "" : "."),
                    s.substring(i));

        }
    }

    /**
     * 给定字符串将其转换为可能性 ip 集合
     * @param s 字符串
     * @return ip 集合
     */
    private static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        if (s == null || s.length() < minStringLen) {
            return result;
        }
        helper(result, 0, "", s);
        return result;
    }

    public static void main(String[] args) {
        List<String> result = restoreIpAddresses("010010");
        result.forEach(System.out::println);
    }
}
