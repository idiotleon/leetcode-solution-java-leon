/**
 * https://leetcode.com/problems/ipo/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/ipo/discuss/98210/Very-Simple-(Greedy)-Java-Solution-using-two-PriorityQueues
 *  https://leetcode.com/problems/ipo/discuss/98210/Very-Simple-(Greedy)-Java-Solution-using-two-PriorityQueues/102560
 */
package com.zea7ot.lc.lvl4.lc0502;

import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionApproach0Greedy {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        final int L = Profits.length;
        Queue<Pair> minHeapCap = new PriorityQueue<Pair>((a, b) -> Integer.compare(a.capital, b.capital));
        Queue<Pair> maxHeapPro = new PriorityQueue<Pair>((a, b) -> Integer.compare(b.profit, a.profit));
        
        for(int i = 0; i < L; i++){
            minHeapCap.add(new Pair(Profits[i], Capital[i]));
        }
        
        for(int i = 0; i < k; i++){
            while(!minHeapCap.isEmpty() && minHeapCap.peek().capital <= W){
                maxHeapPro.add(minHeapCap.poll());
            }
            if(maxHeapPro.isEmpty()) break;
            W += maxHeapPro.poll().profit;
        }
        
        return W;
    }
    
    private class Pair{
        protected int profit;
        protected int capital;
        
        protected Pair(int profit, int capital){
            this.profit = profit;
            this.capital = capital;
        }
    }
}