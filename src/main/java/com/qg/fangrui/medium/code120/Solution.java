package com.qg.fangrui.medium.code120;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Triangle
 * @author FunriLy
 * Created by FunriLy on 2018/2/2.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 动态规划法 : 自底向上
     * 找出二维数组中路径最小的路线值
     * @param triangle 二维数组
     * @return 最小路线值
     */
    private static int minimumTotal(List<List<Integer>> triangle) {
        int minNum = 2;
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[] result = new int[triangle.size()];
        for (int i=0; i<triangle.size(); i++) {
            result[i] = triangle.get(triangle.size()-1).get(i);
        }
        for (int i=triangle.size()-minNum; i>=0; i--) {
            for (int j=0; j<=i; j++) {
                result[j] = Math.min(result[j], result[j+1]) + triangle.get(i).get(j);
            }
        }
        return result[0];
    }

    public static void main(String[] args) {
        List<Integer> list1 = Collections.singletonList(2);
        List<Integer> list2 = Arrays.asList(3, 4);
        List<Integer> list3 = Arrays.asList(6, 5, 7);
        List<Integer> list4 = Arrays.asList(4, 1, 8, 3);

        List<List<Integer>> triangle = Arrays.asList(list1, list2, list3, list4);
        System.out.println(minimumTotal(triangle));
    }
}
