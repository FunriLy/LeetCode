package com.qg.fangrui.medium.code079;

/**
 * Word Search
 * @author FunriLy
 * Created by FunriLy on 2018/1/25.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 递归调用从当前目标值检查矩阵中是否包含该单词
     * @param board 给定矩阵
     * @param word 给定单词
     * @param index 单词检查索引
     * @param row 矩阵检查索引
     * @param col 矩阵检查索引
     * @param visited 是否已经访问过标记矩阵
     * @return 若ongoing当前索引开始包含有单词返回 true 否则返回false
     */
    private static boolean hasExist(char[][] board, String word,
                                    int index, int row, int col,
                                    boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (row >= 0 && col >= 0 && row < board.length && col < board[0].length
                && board[row][col] == word.charAt(index) && !visited[row][col]) {
            index++;
            visited[row][col] = true;
            if (hasExist(board, word, index, row+1, col, visited)
                    || hasExist(board, word, index, row, col+1, visited)
                    || hasExist(board, word, index, row-1, col, visited)
                    || hasExist(board, word, index, row, col-1, visited)) {
                return true;
            }
            visited[row][col] = false;
        }
        return false;
    }

    /**
     * 检查矩阵中是否含有目标单词
     * @param board 矩阵
     * @param word 单词
     * @return 若矩阵中含有目标单词返回 true 否则返回 false
     */
    private static boolean exist(char[][] board, String word) {
        if (board==null || board.length==0 || board[0].length==0 || "".equals(word)) {
            return false;
        }

        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                visited[i][j] = false;
            }
        }

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                // 避免每一个起始索引都要进行函数调用
                if (board[i][j] == word.charAt(0) && hasExist(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
                {'C', 'A', 'A', 'F'},
                {'A', 'A', 'A', 'G'},
                {'B', 'C', 'D', 'H'}
        };

        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
        System.out.println(exist(board, "AAB"));
    }
}
