/**
 * https://leetcode.com/problems/sliding-puzzle/
 */
package com.polyg7ot.lc.lvl5.lc0773;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SolutionApproachBFS {
    public int slidingPuzzle(int[][] board) {
        // sanity check
        if(board == null || board.length == 0) return 0;
        
        // boundaries of the board
        final int NR = board.length, NC = board[0].length;
        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        
        StringBuilder builder = new StringBuilder();
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                builder.append(board[row][col]);
            }
        }
        
        queue.add(builder.toString());
        visited.add(builder.toString());
        int count = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                String curBoard = queue.poll();
                
                if(curBoard.equals("123450")) return count;
                
                int pos = curBoard.indexOf('0');
                final int[] DIRS = {-1, 1, -3, 3};
                
                for(int d = 0; d < DIRS.length; d++){
                    int next = pos + DIRS[d];
                    if(next < 0 || next >= curBoard.length()) continue;
                    // two edge cases
                    if(pos == 3 && DIRS[d] == -1) continue;
                    if(pos == 2 && DIRS[d] == 1) continue;
                    
                    String nextBoard = swap(curBoard, pos, next);
                    if(!visited.contains(nextBoard)){
                        queue.add(nextBoard);
                        visited.add(nextBoard);
                    }
                }
            }
            
            count++;
        }
        
        return -1;
    }
    
    // to swap chars
    private String swap(String str, int i, int j){
        StringBuilder builder = new StringBuilder(str);
        char temp = builder.charAt(i);
        builder.setCharAt(i, builder.charAt(j));
        builder.setCharAt(j, temp);
        
        return builder.toString();
    }
}