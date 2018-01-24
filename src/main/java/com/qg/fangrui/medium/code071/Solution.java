package com.qg.fangrui.medium.code071;

import java.util.LinkedList;

/**
 * Simplify Path
 * @author FunriLy
 * Created by FunriLy on 2018/1/24.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 简化给定的文件路径
     * @param path 文件路径
     * @return 简化后的文件路径
     */
    private static String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }

        LinkedList<String> list = new LinkedList<>();
        String[] strs = path.split("/");

        for (String str : strs) {
            if (str.length() == 0 || ".".equals(str)) {
                // 当字符串为空或者为"."，不做任何操作。
                continue;
            } else if (!"..".equals(str)) {
                // 当字符串不为".."，则将字符串入栈。
                list.push(str);
            } else {
                // 当字符串为"..", 则弹栈
                if (!list.isEmpty()) {
                    // 再做一层安全防卫
                    list.pop();
                }
            }
        }

        StringBuilder result = new StringBuilder();

        if (list.isEmpty()) {
            result.append("/");
        } else {
            while (!list.isEmpty()) {
                result.append("/").append(list.removeLast());
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }
}
