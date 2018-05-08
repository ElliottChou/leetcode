/*
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (28.18%)
 * Total Accepted:    176.7K
 * Total Submissions: 626.9K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * Example:
 * 
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 
 * 
 */
class Solution {

    public boolean exist(char[][] board, String word) {
        if(board.length==0 || word.length()==0) return false;
        int[][] flag = new int[board.length][board[0].length];
        for (int i = 0; i < flag.length; i++) {
            for (int j = 0; j < flag[0].length; j++) flag[i][j] = 0;
        }
        for (int i = 0; i < flag.length; i++) {
            for (int j = 0; j < flag[0].length; j++) {
                if(board[i][j]==word.charAt(0)){
                    flag[i][j] = 1;
                    if(word.length()==1) return true;
                    if(help(board, flag, word.substring(1), i, j)) return true;
                    flag[i][j] = 0;
                }
            }
        }
        return false;
    }

    public boolean help(char[][] board, int[][] flag, String word, int i, int j) {
        if(i+1<flag.length){
            if(flag[i+1][j]==0&&board[i+1][j]==word.charAt(0)){
                flag[i+1][j] = 1;
                if(word.length()==1) return true;
                if(help(board, flag, word.substring(1), i+1, j)) return true;
                flag[i+1][j] = 0;
            }
        }
        if(i-1>=0){
            if(flag[i-1][j]==0&&board[i-1][j]==word.charAt(0)){
                flag[i-1][j] = 1;
                if(word.length()==1) return true;
                if(help(board, flag, word.substring(1), i-1, j)) return true;
                flag[i-1][j] = 0;
            }
        }
        if(j+1<flag[0].length){
            if(flag[i][j+1]==0&&board[i][j+1]==word.charAt(0)){
                flag[i][j+1] = 1;
                if(word.length()==1) return true;
                if(help(board, flag, word.substring(1), i, j+1)) return true;
                flag[i][j+1] = 0;
            }
        }
        if(j-1>=0){
            if(flag[i][j-1]==0&&board[i][j-1]==word.charAt(0)){
                flag[i][j-1] = 1;
                if(word.length()==1) return true;
                if(help(board, flag, word.substring(1), i, j-1)) return true;
                flag[i][j-1] = 0;
            }
        }
        return false;
    }
}
