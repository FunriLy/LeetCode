package com.qg.fangrui.medium.code077;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Combinations
 * @author FunriLy
 * Created by FunriLy on 2018/1/25.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 由给定范围中取出数字加入到集合
     * @param result 集合结果
     * @param list 当前集合
     * @param start 范围起始
     * @param end 范围终止
     * @param k 当前集合空缺个数
     */
    private static void add(List<List<Integer>> result, List<Integer> list, int start, int end , int k) {
        if (k <= 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=start; i<=end ; i++) {
            list.add(i);
            add(result, list, i+1, end, k-1);
            list.remove(new Integer(i));
        }
    }

    /**
     * 将 1-n 个数中组成个数为 k 的集合
     * @param n 给定范围n
     * @param k 集合个数
     * @return 集合结果
     */
    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(n <= 0 || k <= 0 || n < k) {
            return result;
        }
        List<Integer> list = new LinkedList<>();

        add(result, list, 1, n, k);

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combine(4, 2);
        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }
}
