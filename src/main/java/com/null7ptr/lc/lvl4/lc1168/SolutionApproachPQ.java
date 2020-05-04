/**
 * https://leetcode.com/problems/optimize-water-distribution-in-a-village/
 */
package com.null7ptr.lc.lvl4.lc1168;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SolutionApproachPQ {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        // sanity check
        if(n <= 0 || wells == null || wells.length == 0 || pipes == null) return 0;

        // this is actually n, one of the arguments
        final int N = wells.length;
        Map<Integer, List<int[]>> housePipes = new HashMap<Integer, List<int[]>>();
        for(int[] pipe : pipes){
            int pipe1Idx = pipe[0] - 1;
            int pipe2Idx = pipe[1] - 1;
            int cost = pipe[2];
            housePipes.putIfAbsent(pipe1Idx, new ArrayList<int[]>());
            housePipes.get(pipe1Idx).add(new int[]{pipe2Idx, cost});
            housePipes.putIfAbsent(pipe2Idx, new ArrayList<int[]>());
            housePipes.get(pipe2Idx).add(new int[]{pipe1Idx, cost});
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
                if(housePipes.containsKey(village)){
                    for(int[] cur : housePipes.get(village)){
                        int pipeCost = cur[1];
                        if(pipeCost < wells[cur[0]] && cost[cur[0]] == Integer.MAX_VALUE){
                            wells[cur[0]] = pipeCost;
                            heap.offer(new int[]{pipeCost, cur[0]});
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