/**
 * https://leetcode.com/problems/minimum-cost-to-hire-k-workers/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-cost-to-hire-k-workers/discuss/185085/Java-with-Explanations/348910
 *  https://leetcode.com/problems/minimum-cost-to-hire-k-workers/discuss/185085/Java-with-Explanations
 *  https://leetcode.com/problems/minimum-cost-to-hire-k-workers/discuss/141768/Detailed-explanation-O(NlogN)
 */
package com.an7one.leetcode.lvl5.lc0857;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionApproach0Greedy {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        final int L = quality.length;
        List<Worker> workers = new ArrayList<Worker>();
        
        for(int i = 0; i < L; i++){
            workers.add(new Worker(quality[i], wage[i]));
        }
        
        Collections.sort(workers, (a, b) -> Double.compare(a.ratio, b.ratio));
        
        Queue<Worker> maxHeap = new PriorityQueue<Worker>((a, b) -> Integer.compare(b.quality, a.quality));
        
        int totalQuality = 0;
        double minCost = Double.MAX_VALUE;
        for(Worker worker : workers){
            maxHeap.offer(worker);
            totalQuality += worker.quality;
            
            if(maxHeap.size() > K){
                Worker removed = maxHeap.poll();
                totalQuality -= removed.quality;
            }
            
            if(maxHeap.size() == K){
                minCost = Math.min(totalQuality * worker.ratio, minCost);
            }
        }
        
        return minCost;
    }
    
    private class Worker{
        protected int quality;
        @SuppressWarnings("unused")
        protected int wage;
        protected double ratio;
        
        protected Worker(int quality, int wage){
            this.quality = quality;
            this.wage = wage;
            this.ratio = wage * 1.0  / quality;
        }
    }
}