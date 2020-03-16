/**
 * https://leetcode.com/problems/word-search/
 */
package main.java.lcidiot.lc0079;

class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        
        char[] chars = word.toCharArray();
        for(int row = 0; row < board.length; row++)
            for(int col = 0; col < board[0].length; col++)
                if(exist(board, row, col, chars, 0))
                    return true;
        
        return false;
    }
    
    private boolean exist(char[][] board, 
                          int row, 
                          int col, 
                          char[] chars, 
                          int i){
        if(i == chars.length) return true;
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;
        
        if(board[row][col] != chars[i]) return false;
        
        board[row][col] ^= 256;
        boolean exist = exist(board, row, col + 1, chars, i + 1)
            || exist(board, row, col - 1, chars, i + 1)
            || exist(board, row - 1, col, chars, i + 1)
            || exist(board, row + 1, col, chars, i + 1);
        board[row][col] ^= 256;

        return exist;
    }
}