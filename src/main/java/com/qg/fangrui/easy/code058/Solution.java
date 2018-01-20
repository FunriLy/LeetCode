package com.qg.fangrui.easy.code058;

/**
 * Length of Last Word
 * @author FunriLy
 * Created by FunriLy on 2018/1/20.
 * From small beginnings comes great things.
 */
public class Solution {

    private static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        String[] strs = s.split(" ");
        if (strs.length != 0) {
            String str = strs[strs.length - 1];
            return str.length();
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(" "));
    }
}
