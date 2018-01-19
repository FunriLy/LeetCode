package com.qg.fangrui.medium.code36;

/**
 * Valid Sudoku
 * @author FunriLy
 * Created by FunriLy on 2018/1/16.
 * From small beginnings comes great things.
 */
public class Solution {

    /*
    这道题我想得太复杂了，总想各种方面的优化，其实这道题还是很简单的
    详细直接看 http://blog.csdn.net/linhuanmars/article/details/20748171
    久解不出后直接采用了这个
     */

    /**
     * 给定二维数组(数独)，判断该二维数组是否有数独填充的解法
     * @param board 二维数组
     * @return 若存在解返回 true 否则返回 false
     */
    private static boolean isValidSudoku(char[][] board) {
        int maxValue = 9;
        if(board==null || board.length!=maxValue || board[0].length!=maxValue) {
            return false;
        }
        for(int i=0;i<maxValue;i++)
        {
            boolean[] map = new boolean[9];
            for(int j=0;j<maxValue;j++)
            {
                if(board[i][j] != '.')
                {
                    if(map[(board[i][j]-'1')])
                    {
                        return false;
                    }
                    map[(board[i][j]-'1')] = true;
                }
            }
        }
        for(int j=0;j<9;j++)
        {
            boolean[] map = new boolean[9];
            for(int i=0;i<9;i++)
            {
                if(board[i][j] != '.')
                {
                    if(map[(board[i][j]-'1')])
                    {
                        return false;
                    }
                    map[(board[i][j]-'1')] = true;
                }
            }
        }
        for(int block=0;block<9;block++)
        {
            boolean[] map = new boolean[9];
            for(int i=block/3*3;i<block/3*3+3;i++)
            {
                for(int j=block%3*3;j<block%3*3+3;j++)
                {
                    if(board[i][j] != '.')
                    {
                        if(map[(board[i][j]-'1')])
                        {
                            return false;
                        }
                        map[(board[i][j]-'1')] = true;
                    }
                }
            }
        }
        return true;
    }
}
