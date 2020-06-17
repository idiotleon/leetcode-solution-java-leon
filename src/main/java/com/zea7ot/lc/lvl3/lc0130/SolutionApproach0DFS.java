/**
 * https://leetcode.com/problems/surrounded-regions/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.zea7ot.lc.lvl3.lc0130;

public class SolutionApproach0DFS {
    private int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int NR, NC;
    
    public void solve(char[][] board) {
        // sanity check
        if(board == null || board.length == 0 || board[0].length == 0) return;
        
        // boundaries
        this.NR = board.length;
        this.NC = board[0].length;
        
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(board[row][col] == 'O'){
                    if(isBorderAttached(board, row, col)){
                        mark(board, row, col, 'O');
                    }
                    else mark(board, row, col, 'X');
                }
            }
        }
    }
    
    private void mark(char[][] board, int row, int col, char marker){
        if(row < 0 || col < 0 || row >= NR || col >= NC || board[row][col] != 'Q') return;
        
        board[row][col] = marker;
        
        for(final int[] DIR : DIRS){
            int r = row + DIR[0], c = col + DIR[1];
            mark(board, r, c, marker);
        }
    }
    
    private boolean isBorderAttached(char[][] board, int row, int col){
        if(row < 0 || row >= NR || col < 0 || col >= NC || board[row][col] != 'O') return false;
        
        if(board[row][col] == 'O' && (row == 0 || col == 0 || row == NR - 1 || col == NC - 1)) return true;
        
        board[row][col] = 'Q';
        
        boolean res = false;
        
        for(final int[]  DIR : DIRS){
            res = res || isBorderAttached(board, row + DIR[0], col + DIR[1]);
        }
        
        return res;

        /* equivalently
        return isBorderAttached(board, row - 1, col) 
            || isBorderAttached(board, row + 1, col) 
            || isBorderAttached(board, row, col - 1) 
            || isBorderAttached(board, row, col + 1);
        */
    }
}