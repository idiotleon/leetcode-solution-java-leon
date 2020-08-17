/**
 * https://leetcode.com/problems/surrounded-regions/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 */
package com.zea7ot.leetcode.lvl3.lc0130;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionApproach0BFS {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public void solve(char[][] board) {
        // sanity check
        if(board == null || board.length == 0 || board[0].length == 0) return;
        
        final int NR = board.length, NC = board[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        
        // to get all 'O's on the border firstly
        for(int row = 0; row < NR; row++){
            if(board[row][0] == 'O'){
                board[row][0] = '+';
                queue.add(new int[]{row, 0});
            }
            
            if(board[row][NC - 1] == 'O'){
                board[row][NC - 1] = '+';
                queue.add(new int[]{row, NC - 1});
            }
        }
        
        for(int col = 1; col < NC - 1; col++){
            if(board[0][col] == 'O'){
                board[0][col] = '+';
                queue.add(new int[]{0, col});
            }
            
            if(board[NR - 1][col] == 'O'){
                board[NR - 1][col] = '+';
                queue.add(new int[]{NR - 1, col});
            }
        }
        
        // BFS for the 'O's, and mark it as '+'
        while(!queue.isEmpty()){
            int[] top = queue.poll();
            
            for(final int[] DIR : DIRS){
                int r = top[0] + DIR[0], c = top[1] + DIR[1];
                
                if(r < 0 || r >= NR || c < 0 || c >= NC || board[r][c] != 'O') continue;
                board[r][c] = '+';
                queue.add(new int[]{r, c});
            }
        }
        
        // to turn all '+' to 'O', and 'O' to 'X'
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(board[row][col] == 'O') board[row][col] = 'X';
                if(board[row][col] == '+') board[row][col] = 'O';
            }
        }
    }
}