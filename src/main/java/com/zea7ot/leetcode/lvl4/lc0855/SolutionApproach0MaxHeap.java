/**
 * https://leetcode.com/problems/exam-room/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 */
package com.zea7ot.leetcode.lvl4.lc0855;

import java.util.PriorityQueue;

public class SolutionApproach0MaxHeap {
    private int N;
    private PriorityQueue<int[]> maxHeap;

    public SolutionApproach0MaxHeap(int N) {
        this.N = N;
        this.maxHeap = new PriorityQueue<int[]>((a, b) -> {
            int distanceA = intervalToDistance(a);
            int distanceB = intervalToDistance(b);
            if(distanceA != distanceB) 
                return Integer.compare(distanceB, distanceA);
            // if distances are the same, to sort with the lowest number
            return Integer.compare(a[0], b[0]);
        });
        maxHeap.offer(new int[]{-1, N});
    }
    
    public int seat() {
        int res = 0;
        int[] interval = maxHeap.poll();
        if(interval[0] == -1) res = 0;
        else if(interval[1] == N) res = N - 1;
        else res = interval[0] + (interval[1] - interval[0]) / 2;
        
        maxHeap.add(new int[]{interval[0], res});
        maxHeap.add(new int[]{res, interval[1]});
        return res;
    }
    
    public void leave(int p) {
        int[] leftInterval = null;
        int[] rightInterval = null;
        for(int[] interval : maxHeap){
            if(interval[1] == p) leftInterval = interval;
            if(interval[0] == p) rightInterval = interval;
        }
        
        maxHeap.remove(leftInterval);
        maxHeap.remove(rightInterval);
        maxHeap.add(new int[]{leftInterval[0], rightInterval[1]});
    }
    
    private int intervalToDistance(int[] interval){
        int distance = 0;
        if(interval[0] == -1) distance = interval[1];
        else if(interval[1] == N) distance = N - 1 - interval[0];
        else distance = (interval[1] - interval[0]) / 2;
        
        return distance;
    }
}