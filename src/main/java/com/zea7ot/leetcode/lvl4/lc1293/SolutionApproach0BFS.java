/**
 * https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
 *
 * Time Complexity:     O(`NR` * `NC`)
 * Space Complexity:    O(`NR` * `NC`)
 *
 * References:
 *  https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/discuss/451787/Python-O(m*n*k)-BFS-Solution-with-Explanation/732304
 */
package com.zea7ot.leetcode.lvl4.lc1293;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0BFS {
    private static final int[] DIRS = {0, -1, 0 , 1, 0};
    
    // not used
    // private static final int EMPTY = 0;
    private static final int OBSTACLE = 1;
    
    public int shortestPath(int[][] grid, int k) {
        final int NR = grid.length, NC = grid[0].length;
        
        Integer[][] seen = new Integer[NR][NC];
        
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, k));
        
        int steps = 0;
        
        while(!queue.isEmpty()){
            final int SIZE = queue.size();
            
            for(int i = 0; i < SIZE; ++i){
                Node cur = queue.poll();
                int row = cur.row;
                int col = cur.col;
                int kCur = cur.k;
                
                if(row == NR - 1 && col == NC - 1) return steps;
                
                for(int d = 0; d < 4; ++d){
                    int nr = row + DIRS[d], nc = col + DIRS[d + 1];
                    
                    if(nr < 0 || nr >= NR || nc < 0 || nc >= NC) continue;
                    int kLeft = (grid[nr][nc] == OBSTACLE) ? kCur - 1 : kCur;
                    
                    if(kLeft < 0 || (seen[nr][nc] != null && seen[nr][nc] >= kLeft)) continue;
                    
                    seen[nr][nc] = kLeft;
                    queue.offer(new Node(nr, nc, kLeft));
                }
            }
            
            ++steps;
        }
        
        return -1;
    }
    
    private class Node{
        private int row;
        private int col;
        private int k;
        
        private Node(int row, int col, int k){
            this.row = row;
            this.col = col;
            this.k = k;
        }
    }
}
