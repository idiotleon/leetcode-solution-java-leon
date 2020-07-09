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
 *  https://leetcode.com/problems/maximum-profit-in-job-scheduling/discuss/408957/DP%2BBinary-search-(Java)
 */
package com.zea7ot.lc.lvl4.lc1235;

import java.util.Arrays;

public class SolutionApproach0DPWithBinarySearch {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for(int i=0;i<n;i++) {
            jobs[i] = new Job(startTime[i],endTime[i],profit[i]);
        }
        return schedule(jobs);
    }
    
    private int schedule(Job[] jobs){
        Arrays.sort(jobs, (a, b) -> Integer.compare(a.end, b.end));
        
        final int N = jobs.length;
        int[] dp = new int[N];
        dp[0] = jobs[0].profit;
        for(int i = 1; i < N; i++){
            // the profit including the current job
            int profit = jobs[i].profit;
            int idx = search(jobs, i);
            if(idx != -1) profit += dp[idx];
            // to get the max profit of:
            //  1. excluding the current job
            //  2. including the current job
            dp[i] = Math.max(profit, dp[i - 1]);
        }
        
        return dp[N - 1];
    }
    
    private int search(Job[] jobs, int index){
        int lo = 0, hi = index - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(jobs[mid].end <= jobs[index].start){
                if(jobs[mid + 1].end <= jobs[index].start) lo = mid + 1;
                else return mid;
            }else hi = mid - 1;
        }
        
        return -1;
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