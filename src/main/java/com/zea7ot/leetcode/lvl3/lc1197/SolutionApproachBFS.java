/**
 * https://leetcode.com/problems/minimum-knight-moves/
 * 
 * For example, to reach (1,1) from (0, 0), the best way is to get (2, -1) or (-1, 2) first, then (1,1) (two steps). 
 * If we eliminate all coordinates with negative numbers, then we can't reach (1,1) from (0, 0) within two steps.
 */
package com.zea7ot.leetcode.lvl3.lc1197;

import java.util.LinkedList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class SolutionApproachBFS {
    private static final int[][] DIRS = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    
    public int minKnightMoves(int x, int y) {
        // symmetry for axes
        x = Math.abs(x);
        y = Math.abs(y);
        
        int count = -1;
        
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{x, y});
        
        Set<String> visited = new HashSet<String>();
        visited.add(x + "," + y);
        
        while(!queue.isEmpty()){
            count++;
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                int row = cur[0], col = cur[1];
                if(row == 0 && col == 0) return count;
                
                for(int[] dir : DIRS){
                    int r = row + dir[0], c = col + dir[1];
                    String key = r + "," + c;
                    if(!visited.contains(key) && r >= -1 && c >= -1){
                        queue.add(new int[]{r, c});
                        visited.add(key);
                    }
                }
            }
        }
        
        return -1;
    }
}