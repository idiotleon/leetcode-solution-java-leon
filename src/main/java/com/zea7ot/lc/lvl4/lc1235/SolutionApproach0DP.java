/**
 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-profit-in-job-scheduling/discuss/408985/Java-fast-DP/367947
 *  https://leetcode.com/problems/maximum-profit-in-job-scheduling/discuss/408985/Java-fast-DP
 */
package com.zea7ot.lc.lvl4.lc1235;

import java.util.Arrays;

public class SolutionApproach0DP {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profits) {
        final int N = startTime.length;
        Job[] jobs = new Job[N];
        for(int i = 0; i < N; i++) 
            jobs[i] = new Job(startTime[i], endTime[i], profits[i]);
        Arrays.sort(jobs, (a, b) -> Integer.compare(a.end, b.end));
        
        int[] dp = new int[N];
        dp[0] = jobs[0].profit;
        for(int i = 1; i < N; ++i){
            dp[i] = jobs[i].profit;
            for(int j = i - 1; j >= 0; j--){
                if(jobs[j].end <= jobs[i].start){
                    dp[i] = Math.max(dp[i], jobs[i].profit + dp[j]);
                    break;
                }
            }
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        
        return dp[N - 1];
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