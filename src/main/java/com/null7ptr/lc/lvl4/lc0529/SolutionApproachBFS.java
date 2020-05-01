/**
 * https://leetcode.com/problems/minesweeper/
 */
package com.null7ptr.lc.lvl4.lc0529;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SolutionApproachBFS {
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
        
        LinkedList<int[]> queue = new LinkedList<int[]>();
        queue.add(click);
        
        while(!queue.isEmpty()){
            int[] cur = queue.removeFirst();
            int row = cur[0], col = cur[1];
            
            int count = 0;
            List<int[]> neighbors = new ArrayList<int[]>();

            if(board[row][col] == 'E'){
                for(int[] dir : DIRS){
                    int r = row + dir[0], c = col + dir[1];
                    
                    if(r >= 0 && r < NR && c >= 0 && c < NC){
                        if(board[r][c] == 'M') count++;
                        else neighbors.add(new int[]{r, c});
                    }
                }
                
                if(count == 0){
                    board[row][col] = 'B';
                    for(int i = 0; i < neighbors.size(); i++){
                        queue.add(neighbors.get(i));
                    }
                    // to need to clear the neighbors,
                    // since it is newly created every time.
                    // neighbors.clear();
                }else board[row][col] = (char)('0' + count);
            }
        }
        
        return board;
    }   
}