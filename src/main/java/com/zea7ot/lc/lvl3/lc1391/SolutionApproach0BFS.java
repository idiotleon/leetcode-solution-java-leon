/**
 * https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 * 
 * References:
 *  https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/discuss/547371/Java-clean-BFS
 */
package com.zea7ot.lc.lvl3.lc1391;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionApproach0BFS {
    final int[][][] DIRS = {
        {{0, -1}, {0, 1}},
        {{-1, 0}, {1, 0}},
        {{0, -1}, {1, 0}},
        {{0, 1}, {1, 0}},
        {{0, -1}, {-1, 0}},
        {{-1, 0}, {0, 1}}
    };
    
    public boolean hasValidPath(int[][] grid) {
        // sanity check
        if(grid == null || grid.length == 0 || grid[0].length == 0) return false;
        
        final int NR = grid.length, NC = grid[0].length;
        boolean[][] visited = new boolean[NR][NC];
        
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] top = queue.poll();
            int row = top[0], col = top[1];
            for(final int[] DIR : DIRS[grid[row][col] - 1]){
                int r = row + DIR[0], c = col + DIR[1];
                if(r < 0 || r >= NR || c < 0 || c >= NC || visited[r][c]) continue;
                for(final int[] BACK : DIRS[grid[r][c] - 1]){
                    if(r + BACK[0] == row && c + BACK[1] == col){
                        visited[r][c] = true;
                        queue.add(new int[]{r, c});
                    }
                }
            }
        }
        
        return visited[NR - 1][NC - 1];
    }
}