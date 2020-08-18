/**
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/
 * 
 * Time Complexity:     O(buildings * NR * NC)
 * Space Complexity:    O(NR * NC)
 * 
 * References:
 *  https://leetcode.com/problems/shortest-distance-from-all-buildings/discuss/76886/Share-a-Java-implement
 */
package com.zea7ot.leetcode.lvl4.lc0317;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SolutionApproach0BFS {
    private static final int[] DIRS = {0, -1, 0, 1, 0};
    
    public int shortestDistance(int[][] grid) {
        final int NR = grid.length, NC = grid[0].length;
        
        List<Building> buildings = new ArrayList<Building>();
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(grid[row][col] == 1)
                    buildings.add(new Building(row, col, 0));
                grid[row][col] = -grid[row][col];
            }
        }
        
        int[][] distances = new int[NR][NC];
        for(int k = 0; k < buildings.size(); k++){
            bfs(buildings.get(k), k, distances, grid);
        }
        
        int ans = -1;
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(grid[row][col] == buildings.size() && (ans < 0 || distances[row][col] < ans)){
                    ans = distances[row][col];
                }
            }
        }
        
        return ans;
    }
    
    private void bfs(Building building, int k, int[][] distances, int[][] grid){
        final int NR = grid.length, NC = grid[0].length;
        
        Queue<Building> queue = new ArrayDeque<Building>();
        queue.add(building);
        while(!queue.isEmpty()){
            Building top = queue.poll();
            distances[top.row][top.col] += top.distance;
            for(int d = 0; d < 4; d++){
                int r = top.row + DIRS[d], c = top.col + DIRS[d + 1];
                if(r < 0 || r >= NR || c < 0 || c >= NC || grid[r][c] != k) continue;
                grid[r][c] = k + 1;
                queue.add(new Building(r, c, top.distance + 1));
            }
        }
    }
    
    private class Building{
        protected int row;
        protected int col;
        protected int distance;
        
        protected Building(int row, int col, int distance){
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
}