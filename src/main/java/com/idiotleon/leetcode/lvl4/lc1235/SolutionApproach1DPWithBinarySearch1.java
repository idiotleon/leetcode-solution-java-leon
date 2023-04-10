/**
 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * `dp[time] = profit` means that, within the first `time` duration, one can make `profit` at most.
 * If one does NOT do this job, no profit is going to be made.
 * If one does this job, to binary search in the dp to find the largest profit one can make before start time `job[i].start`
 * 
 * #knapsack
 * 
 * References:
 *  https://leetcode.com/problems/maximum-profit-in-job-scheduling/discuss/409009/JavaC%2B%2BPython-DP-Solution
 *  https://leetcode.com/problems/maximum-profit-in-job-scheduling/discuss/409009/JavaC%2B%2BPython-DP-Solution
 */
package com.idiotleon.leetcode.lvl4.lc1235;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SolutionApproach1DPWithBinarySearch1 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profits) {
        final int N = startTime.length;
        Job[] jobs = new Job[N];
        for(int i = 0; i < N; i++) 
            jobs[i] = new Job(startTime[i], endTime[i], profits[i]);
        
        Arrays.sort(jobs, (a, b) -> Integer.compare(a.end, b.end));
        List<Integer> dpEndTime = new ArrayList<Integer>();
        List<Integer> dpProfit = new ArrayList<Integer>();
        
        // to pad the lists to avoid IndexOutOfBound
        dpEndTime.add(0);
        dpProfit.add(0);
        
        for(Job job : jobs){
            int start = job.start, end = job.end, profit = job.profit;
            // to find the previous endTime index
            int prevIdx = Collections.binarySearch(dpEndTime, start);
            if(prevIdx < 0) prevIdx = -prevIdx - 2;
            int curProfit = dpProfit.get(prevIdx) + profit;
            int maxProfit = dpProfit.get(dpProfit.size() - 1);
            if(curProfit > maxProfit){
                dpProfit.add(curProfit);
                dpEndTime.add(end);
            }
        }
        
        return dpProfit.get(dpProfit.size() - 1);
    }

    private class Job{
        protected int start;
        protected int end;
        protected int profit;
        
        protected Job(int start, int end, int profit){
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
}