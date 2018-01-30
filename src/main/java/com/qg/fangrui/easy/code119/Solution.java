package com.qg.fangrui.easy.code119;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's Triangle II
 * @author FunriLy
 * Created by FunriLy on 2018/1/30.
 * From small beginnings comes great things.
 */
public class Solution {

    /*
    参考资料来源于LeetCode : https://leetcode.com/problems/pascals-triangle-ii/discuss/38437/
     */

    /**
     * 取出杨辉三角形中的第 k 行
     * @param rowIndex 目标值
     * @return 第 k 行杨辉三角形
     */
    private static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<=rowIndex; i++) {
            list.add(1);
            for (int j=i-1; j>0; j--) {
                list.set(j, list.get(j-1) + list.get(j));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getRow(5));
    }
}
