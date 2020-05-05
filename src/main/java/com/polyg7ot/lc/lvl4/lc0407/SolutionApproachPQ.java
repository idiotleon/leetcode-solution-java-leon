/**
 * https://leetcode.com/problems/trapping-rain-water-ii/
 */
package com.polyg7ot.lc.lvl4.lc0407;

import java.util.PriorityQueue;

public class SolutionApproachPQ {
    private static final int[] DIRS = {0, -1, 0, 1, 0};
    
    public int trapRainWater(int[][] heightMap) {
        int ans = 0;
        // sanity check
        if(heightMap == null || heightMap.length == 0) return ans;
        
        final int NR = heightMap.length, NC = heightMap[0].length;
        // min heap, compared by height, the 1st element, 
        // while the rest two are coordinates
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((e0, e1) -> Integer.compare(e0[0], e1[0]));
        int[][] visited = new int[NR][NC];
        
        for(int row = 0; row < NR; row++){
            int[] pos = new int[]{heightMap[row][0], row, 0};
            heap.offer(pos);
            visited[row][0] = 1;
            int maxCol = NC - 1;
            if(maxCol > 0){
                pos = new int[]{heightMap[row][maxCol], row, maxCol};
                heap.offer(pos);
                visited[row][maxCol] = 1;
            }
        }
        
        for(int col = 0; col < heightMap[0].length; col++){
            int[] pos = new int[]{heightMap[0][col], 0, col};
            heap.offer(pos);
            visited[0][col] = 1;
            int maxRow = NR - 1;
            if(maxRow > 0){
                pos = new int[]{heightMap[maxRow][col], maxRow, col};
                heap.offer(pos);
                visited[maxRow][col] = 1;
            }
        }
        
        while(!heap.isEmpty()){
            int[] pos = heap.poll();
            int row = pos[1], col = pos[2];
            int lowestLevel = pos[0];
            for(int d = 0; d < 4; d++){
                int r = row + DIRS[d], c = col + DIRS[d + 1];
                // to ensure valid coordinates
                if(r < 0 || r >= NR || c < 0 || c >= NC) continue;
                // to ensure not visited
                if(visited[r][c] == 1) continue;
                // if any lower level has ever been found
                if(heightMap[r][c] < lowestLevel){
                    ans += lowestLevel - heightMap[r][c];
                    heap.offer(new int[]{lowestLevel, r, c});
                }else{
                    heap.offer(new int[]{heightMap[r][c], r, c});
                }
                
                visited[r][c] = 1;
            }
        }
        
        return ans;
    }
}