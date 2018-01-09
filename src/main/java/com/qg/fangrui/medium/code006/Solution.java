package com.qg.fangrui.medium.code006;

/**
 * ZigZag Conversion
 * @author FunriLy
 * Created by FunriLy on 2018/1/9.
 * From small beginnings comes great things.
 */
public class Solution {

    /*
    最开始完全看不懂题目规则，参考资料 http://www.cnblogs.com/springfor/p/3889414.html
     */

    /**
     * 将给定字符串按照 z 字型调整
     * @param s 给定字符串
     * @param numRows 行数
     * @return 新构造字符串
     */
    private static String convert(String s, int numRows) {
        if (s == null || numRows<=0) {
            return null;
        }
        if (s.length() <= 1) {
            return s;
        }

        StringBuilder str = new StringBuilder();
        int size = 2 * numRows - 2;

        for (int i=0; i<numRows; i++) {
            for (int j=i; j<s.length(); j+=size) {
                str.append(s.charAt(j));
                if (i!=0 && j!=numRows-1) {
                    int temp = size + j - 2 * i;
                    if (temp < s.length()) {
                        str.append(s.charAt(temp));
                    }
                }
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAHNAPLSIIGYIR", 3));
    }
}
