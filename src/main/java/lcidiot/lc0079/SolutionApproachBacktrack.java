/**
 * https://leetcode.com/problems/word-search/
 * 
 * Time Complexity: O(M * N * (4 ^ L))
 * Space Complexity: O(L)
 * M, N: sizes of the char[][] board
 * L: length of the word
 */
package main.java.lcidiot.lc0079;

public class SolutionApproachBacktrack {
    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private static final int MOD = 256;
    private int nr, nc;
    
    public boolean exist(char[][] board, String word) {
        // sanity check
        if(board == null || board.length == 0 || word == null || word.isEmpty()) return false;
        
        // boundaries of char[][] board
        nr = board.length;
        nc = board[0].length;
        
        // backtrack/dfs
        for(int row = 0; row < nr; row++){
            for(int col = 0; col < nc; col++){
                if(backtrack(board, row, col, 0, word)){
                    return true;
                };
            }
        }
        
        return false;
    }
    
    private boolean backtrack(char[][] board, int row, int col, int idx, String word){
        if(idx == word.length()) return true;
        if(row < 0 || col < 0 || row >= nr || col >= nc || board[row][col] != word.charAt(idx)) return false;
        
        board[row][col] ^= MOD;
        
        boolean exists = false;
        
        for(int[] dir : DIRS){
            int r = row + dir[0], c = col + dir[1];
            exists = exists || backtrack(board, r, c, idx + 1, word);
        }
        
        board[row][col] ^= MOD;
        
        return exists;
    }
}