/**
 * https://leetcode.com/problems/trapping-rain-water-ii/
 * 
 * Time Complexity:     O(V + Elg(V))
 * Space Complexity:    O(Elg(V))
 */
package com.zea7ot.lc.lvl4.lc0407;

import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionApproach0DijkstrasAlgorithm {
    private static final int[] DIRS = {0, -1, 0, 1, 0};
    
    public int trapRainWater(int[][] heightMap) {
        int water = 0;
        // sanity check
        if(heightMap == null || heightMap.length == 0) return water;
        
        final int NR = heightMap.length, NC = heightMap[0].length;
        // min heap, compared by height, the 1st element, 
        // while the rest two are coordinates
        Queue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[NR][NC];

        for(int row = 0; row < NR; row++){
            minHeap.offer(new int[]{row, 0, heightMap[row][0]});
            visited[row][0] = true;
            minHeap.offer(new int[]{row, NC - 1, heightMap[row][NC - 1]});
            visited[row][NC - 1] = true;
        }

        for(int col = 1; col < NC - 1; col++){
            minHeap.offer(new int[]{0, col, heightMap[0][col]});
            visited[0][col] = true;
            minHeap.offer(new int[]{NR - 1, col, heightMap[NR - 1][col]});
            visited[NR - 1][col] = true;
        }
        
        while(!minHeap.isEmpty()){
            int[] top = minHeap.poll();
            int row = top[0], col = top[1];
            int lowestLevel = top[2];
            for(int d = 0; d < 4; d++){
                int r = row + DIRS[d], c = col + DIRS[d + 1];
                // to ensure valid coordinates
                // to ensure not visited
                if(r < 0 || r >= NR || c < 0 || c >= NC || visited[r][c]) continue;
                // if any lower level has ever been found
                if(heightMap[r][c] < lowestLevel){
                    water += lowestLevel - heightMap[r][c];
                    minHeap.offer(new int[]{r, c, lowestLevel});
                }else minHeap.offer(new int[]{r, c, heightMap[r][c]});
                
                visited[r][c] = true;
            }
        }
        
        return water;
    }
}