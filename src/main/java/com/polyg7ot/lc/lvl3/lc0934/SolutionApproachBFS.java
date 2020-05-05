/**
 * https://leetcode.com/problems/shortest-bridge/
 */
package com.polyg7ot.lc.lvl3.lc0934;

import java.util.LinkedList;

public class SolutionApproachBFS {
    private static final int[] DIRS = {0, -1, 0, 1, 0};
    
    public int shortestBridge(int[][] nums) {
        boolean hit = false;
        for(int row = 0; row < nums.length; row++){
            for(int col = 0; col < nums[row].length; col++){
                if(nums[row][col] == 1){
                    shortestBridgeFill(nums, row, col);
                    hit = true;
                    break;
                }
            }
            
            if(hit) break;
        }
    
        return shortestBridgePath(nums);
    }

    // to BFS to paint one island to 2
    private void shortestBridgeFill(int[][] nums, int row, int col){
        LinkedList<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{row, col});
        nums[row][col] = 2;
            
        while(!queue.isEmpty()){
            int[] cur = queue.removeFirst();
                
            for(int d = 0; d < 4; d++){
                int r = cur[0] + DIRS[d], c = cur[1] + DIRS[d + 1];
                    
                if(r >= 0 && r < nums.length && c >= 0 && c < nums[r].length && nums[r][c] == 1){
                    nums[r][c] = 2;
                    queue.push(new int[]{r, c});
                }
            }
        }
    }

    // to BFS to reach the 2nd island by steps
    private int shortestBridgePath(int[][] nums){
        LinkedList<int[]> queue = new LinkedList<int[]>();
        for(int row = 0; row < nums.length; row++){
            for(int col = 0; col < nums[row].length; col++){
                if(nums[row][col] == 2){
                    queue.add(new int[]{row, col});
                }
            }
        }
        
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.removeFirst();
                for(int d = 0; d < 4; d++){
                    int r = cur[0] + DIRS[d], c = cur[1] + DIRS[d + 1];
                    
                    if(r < 0 || r >= nums.length || c < 0 || c >= nums[r].length) continue;
                    
                    if(nums[r][c] == 1) return count;
                    
                    if(nums[r][c] == 0){
                        nums[r][c] = 2;
                        queue.add(new int[]{r, c});
                    }
                }
            }
            count++;
        }
        
        return count;
    }
}