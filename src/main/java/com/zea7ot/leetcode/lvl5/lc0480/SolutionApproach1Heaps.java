/**
 * https://leetcode.com/problems/sliding-window-median/
 * 
 * Time Complexity:     O(N * k)
 *  addition in priorities queues costs O(lg(k)), while deletion costs O(k)
 * 
 * Space Complexity:    O(N)
 */
package com.zea7ot.leetcode.lvl5.lc0480;

import java.util.PriorityQueue;

public class SolutionApproach1Heaps {
    public double[] medianSlidingWindow(int[] nums, int k) {
        // sanity check
        if(nums == null || nums.length == 0 || k <= 0) return new double[0];
        
        final int N = nums.length;
        double[] ans = new double[N - k + 1];
        PriorityQueue<Integer> lo = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> hi = new PriorityQueue<Integer>();
        
        for(int i = 0; i < N; i++){
            if(lo.size() <= hi.size()){
                hi.add(nums[i]);
                lo.add(hi.remove());
            }else{
                lo.add(nums[i]);
                hi.add(lo.remove());
            }
        
            if(lo.size() + hi.size() == k){
                double median;

                if(lo.size() == hi.size()){
                    median = ((double)lo.peek() + (double)hi.peek()) / 2;
                }else{
                    median = (double)lo.peek();
                }

                int start = i - k + 1;
                ans[start] = median;
                if(!lo.remove(nums[start])){
                    hi.remove(nums[start]);
                }
            }
        }
        
        return ans;
    }
}