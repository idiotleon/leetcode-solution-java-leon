/**
 * https://leetcode.com/problems/game-of-life/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(1)
 * 
 * to acquire the current state:    board[row][col] & 1
 * to acquire the next state:       board[row][col] >> 1
 * 
 * References:
 *  https://leetcode.com/problems/game-of-life/discuss/73223/Easiest-JAVA-solution-with-explanation
 */
package com.zea7ot.leetcode.lvl3.lc0289;

public class SolutionApproach0BitMasking {
    private final static int STATE_DEAD = 2;
    private final static int STATE_LIVE = 3;

    public void gameOfLife(int[][] board) {
        // sanity check
        if(board == null || board.length == 0) return;
        
        final int NR = board.length, NC = board[0].length;
        
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                int lives = liveNeighbors(row, col, board);
                
                // in the beginning, since every 2nd bit is 0,
                // only the time when the 2nd bit is turned into 1 is of interests.
                if(board[row][col] == 1 && lives >= 2 && lives <= 3){
                    board[row][col] = STATE_LIVE; // to make the 2nd bit 1: 01 -> 11
                }
                
                if(board[row][col] == 0 && lives == 3){
                    board[row][col] = STATE_DEAD; // to make the 2nd bit 1: 00 -> 10
                }
            }
        }
        
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                board[row][col] >>= 1; // to acquire the next/2nd state
            }
        }
    }
    
    private int liveNeighbors(int row, int col, int[][] board){
        final int NR = board.length, NC = board[0].length;
        
        int lives = 0;
        // to check all surroundings
        for(int r = Math.max(row - 1, 0); r <= Math.min(row + 1, NR - 1); r++){
            for(int c = Math.max(col - 1, 0); c <= Math.min(col + 1, NC - 1); c++){
                lives += board[r][c] & 1;
            }
        }
        lives -= board[row][col] & 1;
        return lives;
    }
}