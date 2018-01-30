package com.qg.fangrui.easy.code118;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's Triangle
 * @author FunriLy
 * Created by FunriLy on 2018/1/30.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 构造杨辉三角形
     * @param numRows 行数
     * @return 返回杨辉三角形集合
     */
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows <= 0) {
            return result;
        }

        List<Integer> pre = null;
        for(int i=0; i<numRows; i++) {
            List<Integer> list = new ArrayList<>();
            if (i != 0) {
                pre = result.get(i - 1);
            }
            list.add(1);
            for(int j=1; j<i && pre != null; j++) {
                int temp = pre.get(j-1) + pre.get(j);
                list.add(temp);
            }
            if (i != 0) {
                list.add(1);
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = generate(5);
        result.forEach(System.out::println);
    }
}
