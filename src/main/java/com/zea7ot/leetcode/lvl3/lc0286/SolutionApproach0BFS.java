/**
 * https://leetcode.com/problems/walls-and-gates/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 */
package com.zea7ot.leetcode.lvl3.lc0286;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionApproach0BFS {
    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private static final int EMPTY = Integer.MAX_VALUE;
    // not used
    // private static final int WALL = -1;
    private static final int GATE = 0;
    
    private int NR, NC;
    
    public void wallsAndGates(int[][] rooms) {
        // sanity check
        if(rooms == null || rooms.length == 0) return;
        
        // boundaries
        NR = rooms.length;
        NC = rooms[0].length;
        
        // BFS
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(rooms[row][col] == GATE){
                    queue.add(new int[]{row, col});
                }
            }
        }
        
        int count = 0;
        while(!queue.isEmpty()){
            count++;
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();

                for(int[] dir : DIRS){
                    int r = cur[0] + dir[0], c = cur[1] + dir[1];

                    if(r < 0 || c < 0 || r >= NR || c >= NC || rooms[r][c] != EMPTY) continue;

                    rooms[r][c] = count;
                    queue.add(new int[]{r, c});
                }
            }
        }
    }
}