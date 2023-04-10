/**
 * https://leetcode.com/problems/optimize-water-distribution-in-a-village/
 * 
 * Memory Limit Exceeded
 */
package com.idiotleon.leetcode.lvl4.lc1168;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionApproachPQ1 {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        final int N = wells.length;
        int[][] housePipes = new int[N][N];
        for(int[] pipe : pipes){
            housePipes[pipe[0] - 1][pipe[1] - 1] = pipe[2];
            housePipes[pipe[1] - 1][pipe[0] - 1] = pipe[2];
        }
        
        int[] cost = new int[N];
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((e0, e1) -> Integer.compare(e0[0], e1[0]));
        for(int i = 0; i < N; i++){
            heap.offer(new int[]{wells[i], i});
        }
        
        while(!heap.isEmpty()){
            int[] well = heap.poll();
            int village = well[1];
            if(cost[village] == Integer.MAX_VALUE){
                cost[village] = well[0];
                for(int i = 0; i < N; i++){
                    if(housePipes[village][i] > 0){
                        int pipeCost = housePipes[village][i];
                        if(pipeCost < wells[i] && cost[i] == Integer.MAX_VALUE){
                            wells[i] = pipeCost;
                            heap.offer(new int[]{pipeCost, i});
                        }
                    }
                }
            }
        }
        
        int totalCost = 0;
        for(int i = 0; i < N; i++){
            totalCost += cost[i];
        }
        return totalCost;
    }
}