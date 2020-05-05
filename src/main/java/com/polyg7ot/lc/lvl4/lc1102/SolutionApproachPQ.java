/**
 * https://leetcode.com/problems/path-with-maximum-minimum-value/
 * 
 * Starting from the left corner, we record the max score to each node, 
 * we choose the path with maximum score to the a node which has not been visited, 
 * or re-visit it wherever a higher score is discovered. 
 * And explore all the neighbors, and store scores (the minimum value on the path) to the new node. 
 * If there is a higher score to the node we already visited, 
 * we will revisit it with the new score.
 */
package com.polyg7ot.lc.lvl4.lc1102;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionApproachPQ {
    private static final int[] DIRS = {0, 1, 0, -1, 0};
    
    public int maximumMinimumPath(int[][] A) {
        if(A == null || A.length == 0) return 0;
        
        final int NR = A.length, NC = A[0].length;
        // max heap
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((e0, e1) -> Integer.compare(e1[0], e0[0]));
        heap.offer(new int[]{A[0][0], 0, 0});
        
        int[][] result = new int[NR][NC];
        for(int[] row : result){
            Arrays.fill(row, -1);
        }
        
        while(!heap.isEmpty()){
            int[] cur = heap.poll();
            int row = cur[1], col = cur[2];
            if(row == NR - 1 && col == NC - 1) return cur[0];
            
            for(int d = 0; d < 4; d++){
                int r = row + DIRS[d], c = col + DIRS[d + 1];
                
                if(r < 0 || r >= NR || c < 0 || c >= NC) continue;
                int v = Math.min(A[r][c], cur[0]);
                if(v > result[r][c]){
                    result[r][c] = v;
                    heap.offer(new int[]{v, r, c});
                }
            }
        }
        
        return -1;
    }
}