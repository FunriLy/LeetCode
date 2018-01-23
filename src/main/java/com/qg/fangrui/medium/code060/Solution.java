package com.qg.fangrui.medium.code060;

/**
 * Permutation Sequence
 * @author FunriLy
 * Created by FunriLy on 2018/1/22.
 * From small beginnings comes great things.
 */
public class Solution {

    /*
    找到全排列中的第k个排列：
    一道找规律的数学题，给出数字 n (0<n<=9)，对于小于等于 n 的数字进行组合排序，求出第 k 大的数字
    由网络上资源可得，其规律为：
    a1 = k / (n - 1)!
    k1 = k

    a2 = k1 / (n - 2)!
    k2 = k1 % (n - 2)!
    ...
    an-1 = kn-2 / 1!
    kn-1 = kn-2 / 1!

    an = kn-1 / 0!
    kn = kn-1 % 0!
     */

    /**
     * 找到全排列中的第k个排列
     * @param n 全排序个数
     * @param k 索引位置
     * @return 全排列中的第k个数字
     */
    private static String getPermutation(int n, int k) {
        StringBuilder str = new StringBuilder();
        boolean[] isused = new boolean[n];
        String num = "123456789";
        // 先创建数组存储阶乘
        int[] data = new int[n];
        // 0!
        data[0] = 1;
        for (int i=1; i<n; i++) {
            data[i] = data[i-1] * i;
        }
        k--;
        while (n > 0) {
            int j = k / data[n-1];
            k %= data[n-1];
            for(int i=0; i<=j; i++) {
                if (isused[i]) {
                    j++;
                }
            }
            char ch = num.charAt(j);
            str.append(ch);
            /*
            补充：尽量避免重构字符串……原本是采用删除字符串中字符的方法
            现在减去两个重构字符串操作，换为一个 boolean 数组来控制数字是否已经被读取
            执行时间有 33ms 降为 15ms ……
             */
            isused[j] = true;
            n--;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 2));
    }
}
