package com.qg.fangrui.medium.code089;

import java.util.ArrayList;
import java.util.List;

/**
 * Gray Code
 * @author FunriLy
 * Created by FunriLy on 2018/1/27.
 * From small beginnings comes great things.
 */
public class Solution {

    /*
    工业中的第i个格雷码是这么生成的：(i>>1)^i
    i是指下标，从0开始，对于n的格雷码序列，一共有2^n个数
     */

    /**
     * 递推求解格雷码
     * @param n 给定格雷码位数
     * @return 结果集合
     */
    private static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        // 加入初始值0
        res.add(0);
        for(int i = 0; i < n; i++){
            // 每一轮的最高位
            int highestBit = 1 << i;
            int size = res.size();
            // 逆序添加上一轮里出现的数，不过开头加上这一轮的最高位
            for(int j = size - 1; j >= 0; j--){
                int num = res.get(j);
                num += highestBit;
                res.add(num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> result = grayCode(3);
        result.forEach(System.out::println);
    }
}
