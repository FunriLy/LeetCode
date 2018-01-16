package com.qg.fangrui.medium.code043;

/**
 * Multiply Strings
 * @author FunriLy
 * Created by FunriLy on 2018/1/16.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 实现两个数字字符串之间的乘法
     * 参考资料 http://www.cnblogs.com/springfor/p/3889706.html
     * @param num1 字符串1
     * @param num2 字符串2
     * @return 字符串间乘法结果
     */
    private static String multiply(String num1, String num2) {
        char zero = '0';
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return null;
        }
        // 设置存储空间，最大长度是num1.len + num2.len
        // 比如99 * 99，最大不会超过10000
        int[] result = new int[num1.length() + num2.length()];

        // 先将两个字符串反向
        String numRever1 = new StringBuffer(num1).reverse().toString();
        String numRever2 = new StringBuffer(num2).reverse().toString();

        // 计算每一位的值并存入结果数组
        for (int i=0; i<numRever1.length(); i++) {
            int a = numRever1.charAt(i) - zero;
            for (int j=0; j<numRever2.length(); j++) {
                int b = numRever2.charAt(j) - zero;
                // 注意这里是 i+j ，限制了每个索引位都代表数值位，比如索引0代表个位，索引1代表十位……
                result[i+j] += a*b;
            }
        }

        StringBuilder str = new StringBuilder();
        // 从0开始检查每一个数字位并进行进位操作
        for (int i=0; i<result.length; i++) {
            // 计算当前位真实值并从头部插入结果字符串
            int digit = result[i] % 10;
            // 获取进位值并向前进位
            int carry = result[i] / 10;
            str.insert(0, digit);

            if (i < result.length-1) {
                result[i+1] += carry;
            }
        }

        while (str.length()>0 && str.charAt(0)==zero) {
            str.deleteCharAt(0);
        }
        return str.length() == 0 ? "0" : str.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("999", "18"));
    }
}
