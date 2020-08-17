/**
 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * `dp[time] = profit` means that, within the first `time` duration, one can make `profit` at most.
 * If one does NOT do this job, no profit is going to be made.
 * If one does this job, to binary search in the dp to find the largest profit one can make before start time `job[i].start`
 * 
 * #knapsack
 * 
 * References:
 *  https://leetcode.com/problems/maximum-profit-in-job-scheduling/discuss/409009/JavaC%2B%2BPython-DP-Solution
 */
package com.zea7ot.leetcode.lvl4.lc1235;

import java.util.Arrays;
import java.util.TreeMap;

public class SolutionApproach1DPByTreeMap {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        final int N = startTime.length;
        Job[] jobs = new Job[N];
        for(int i = 0; i < N; i++) 
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        
        Arrays.sort(jobs, (a, b) -> Integer.compare(a.end, b.end));
        TreeMap<Integer, Integer> dp = new TreeMap<Integer, Integer>();
        dp.put(0, 0);
        
        for(Job job : jobs){
            int cur = dp.floorEntry(job.start).getValue() + job.profit;
            if(cur > dp.lastEntry().getValue())
                dp.put(job.end, cur);
        }
        
        return dp.lastEntry().getValue();
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