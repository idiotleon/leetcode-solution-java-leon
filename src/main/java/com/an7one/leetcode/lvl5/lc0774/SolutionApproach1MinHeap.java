/**
 * https://leetcode.com/problems/minimize-max-distance-to-gas-station/
 * 
 * TLEed
 * 
 * Time Complexity: 
 * 
 * Space Complexity: 
 * 
 * References:
 *  https://leetcode.com/problems/minimize-max-distance-to-gas-station/discuss/239907/PriorityQueue-java
 */
package com.an7one.leetcode.lvl5.lc0774;

import java.util.PriorityQueue;

public class SolutionApproach1MinHeap {
    public double minmaxGasDist(int[] stations, int K) {
        PriorityQueue<double[]> minHeap = new PriorityQueue<double[]>((a, b) -> (a[0] / a[1] < b[0] / b[1]) ? 1 : -1);
        
        for(int i = 1; i < stations.length; ++i){
            minHeap.add(new double[]{stations[i] - stations[i - 1], 1.0});
        }
        
        while(K-- > 0){
            double[] cur = minHeap.poll();
            ++cur[1];
            minHeap.add(cur);
        }
        
        double[] value = minHeap.poll();
        return value[0] / value[1];
    }
}