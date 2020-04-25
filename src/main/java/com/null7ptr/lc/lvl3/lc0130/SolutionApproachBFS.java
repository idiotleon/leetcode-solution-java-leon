/**
 * https://leetcode.com/problems/surrounded-regions/
 */
package com.null7ptr.lc.lvl3.lc0130;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionApproachBFS {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public void solve(char[][] board) {
        // sanity check
        if(board.length == 0) return;
        
        int nr = board.length, nc = board[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        
        // to get all 'O's on the edge first
        for(int row = 0; row < nr; row++){
            if(board[row][0] == 'O'){
                board[row][0] = '+';
                queue.add(new int[]{row, 0});
            }
            
            if(board[row][nc - 1] == 'O'){
                board[row][nc - 1] = '+';
                queue.add(new int[]{row, nc - 1});
            }
        }
        
        for(int col = 0; col < nc; col++){
            if(board[0][col] == 'O'){
                board[0][col] = '+';
                queue.add(new int[]{0, col});
            }
            
            if(board[nr - 1][col] == 'O'){
                board[nr - 1][col] = '+';
                queue.add(new int[]{nr - 1, col});
            }
        }
        
        // BFS for the 'O's, and mark it as '+'
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            for(int[] dir : DIRS){
                int r = cur[0] + dir[0], c = cur[1] + dir[1];
                
                if(r >= 0 && r < nr && c >= 0 && c < nc && board[r][c] == 'O'){
                    board[r][c] = '+';
                    queue.add(new int[]{r, c});
                }
            }
        }
        
        // turn all '+' to 'O', and 'O' to 'X'
        for(int row = 0; row < nr; row++){
            for(int col = 0; col < nc; col++){
                if(board[row][col] == 'O') board[row][col] = 'X';
                if(board[row][col] == '+') board[row][col] = 'O';
            }
        }
    }
}