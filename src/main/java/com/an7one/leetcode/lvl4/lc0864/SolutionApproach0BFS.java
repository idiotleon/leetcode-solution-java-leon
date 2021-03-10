/**
 * https://leetcode.com/problems/shortest-path-to-get-all-keys/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 * 
 * References:
 *  https://leetcode.com/problems/shortest-path-to-get-all-keys/discuss/146878/Java-BFS-Solution
 */
package com.an7one.leetcode.lvl4.lc0864;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SolutionApproach0BFS {
    private static final int[] DIRS = {0, -1, 0, 1, 0};
    
    public int shortestPathAllKeys(String[] grid) {
        // sanity checl
        if(grid == null || grid.length == 0 || grid[0].isEmpty()) return 0;
        
        final int NR = grid.length, NC = grid[0].length();
        int x = -1, y = -1;
        int max = -1;
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                char ch = grid[row].charAt(col);
                if(ch == '@'){
                    x = row;
                    y = col;
                }
                
                if(ch >= 'a' && ch <= 'f'){
                    max = Math.max(max, ch - 'a' + 1);
                }
            }
        }
        
        State start = new State(0, x, y);
        Queue<State> queue = new LinkedList<State>();
        queue.offer(start);
        Set<String> visited = new HashSet<String>();
        visited.add(hash(0, x, y));
        int steps = 0;
        
        while(!queue.isEmpty()){
            final int SIZE = queue.size();
            for(int i = 0; i < SIZE; i++){
                State top = queue.poll();
                if(top.key == (1 << max) - 1) return steps;
                
                for(int d = 0; d < 4; d++){
                    int r = top.row + DIRS[d];
                    int c = top.col + DIRS[d + 1];
                    if(r < 0 || r >= NR || c < 0 || c >= NC) continue;
                    int key = top.key;
                    
                    char ch = grid[r].charAt(c);
                    if(ch == '#') continue;
                    if(ch >= 'a' && ch <= 'f') key |= 1 << (ch - 'a');
                    if(ch >= 'A' && ch <= 'F' && ((key >> (ch - 'A')) & 1) == 0) continue;
                    
                    if(visited.contains(hash(key, r, c))) continue;
                    visited.add(hash(key, r, c));
                    queue.offer(new State(key, r, c));
                }
            }
            steps++;
        }
        
        return -1;
    }
    
    private String hash(int key, int row, int col){
        return key + "," + row + "," + col;
    }
    
    private class State{
        protected int key;
        protected int row, col;
        
        protected State(int key, int row, int col){
            this.key = key;
            this.row = row;
            this.col = col;
        }
    }
}