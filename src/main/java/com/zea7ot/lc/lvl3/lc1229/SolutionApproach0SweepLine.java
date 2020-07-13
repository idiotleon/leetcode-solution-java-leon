/**
 * https://leetcode.com/problems/meeting-scheduler/
 * 
 * Time Complexity:     O((N1 + N2) * lg(N1 + N2))
 *  N1, total elements in "slots1" 
 *  N2, total elements in "slots2"
 * 
 * Space Complexity:    O(N1 + N2)
 *  N1, total elements in "slots1" 
 *  N2, total elements in "slots2"
 * 
 * References:
 *  https://leetcode.com/problems/meeting-scheduler/discuss/408506/JavaPython-3-simple-code-using-PriorityQueueheapq-w-brief-explanation-and-analysis
 */
package com.zea7ot.lc.lvl3.lc1229;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionApproach0SweepLine {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        // to help find the !earliest! elighble time
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[0], b[0]));
        for(int[] slot : slots1){
            if(slot[1] - slot[0] >= duration){
                minHeap.offer(slot);
            }
        }
        
        for(int[] slot : slots2){
            if(slot[1] - slot[0] >= duration){
                minHeap.offer(slot);
            }
        }
        
        while(minHeap.size() > 1){
            if(minHeap.poll()[1] >= minHeap.peek()[0] + duration){
                return Arrays.asList(minHeap.peek()[0], minHeap.peek()[0] + duration);
            }
        }
        
        return new ArrayList<Integer>();
    }
}