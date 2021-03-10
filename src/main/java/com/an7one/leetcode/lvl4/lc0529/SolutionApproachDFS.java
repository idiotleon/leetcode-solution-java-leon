/**
 * https://leetcode.com/problems/minesweeper/
 */
package com.an7one.leetcode.lvl4.lc0529;

public class SolutionApproachDFS {
    private static final int[][] DIRS = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};
    
    private int NR, NC;
    
    public char[][] updateBoard(char[][] board, int[] click) {
        // sanity check
        if(board == null || board.length == 0 || click == null || click.length < 2) return board;
        
        // boudaries of the board
        NR = board.length;
        NC = board[0].length;
        
        if(board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }
        
        dfs(board, click[0], click[1]);
        
        return board;
    }
    
    private void dfs(char[][] board, int row, int col){
        if(row < 0 || row >= NR || col < 0 || col >= NC || board[row][col] != 'E') return;
        
        int mines = adjMines(board, row, col);
        
        if(mines > 0) board[row][col] = (char)('0' + mines);
        else{
            board[row][col] = 'B';
            for(int[] dir : DIRS){
                int r = row + dir[0], c = col + dir[1];
                dfs(board, r, c);
            }
        }
    }
    
    private int adjMines(char[][] board, int row, int col){
        int count = 0;
        for(int[] dir : DIRS){
            int r = row + dir[0], c = col + dir[1];
            if(r >= 0 && r < NR && c >= 0 && c < NC && board[r][c] == 'M'){
                count++;
            }
        }
        
        return count;
    }
}