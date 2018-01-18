package com.qg.fangrui.medium.code049;

import java.util.*;

/**
 * Group Anagrams
 * @author FunriLy
 * Created by FunriLy on 2018/1/18.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 归组字符串
     * @param strs 给定字符串数组
     * @return 归组后的字符串结果集合
     */
    private static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chStr = str.toCharArray();
            Arrays.sort(chStr);
            String key = String.valueOf(chStr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            List<String> list = map.get(key);
            list.add(str);
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        for (List<String> list : result) {
            System.out.println(list);
        }
    }
}
