/**
 * https://leetcode.com/problems/most-profit-assigning-work/
 */
package com.zea7ot.lc.lvl2.lc0826;

public class SolutionApproachBucketAndGreedy {
    public int maxProfitAssignment(int[] difficulty, 
                                   int[] profit, 
                                   int[] worker) {
        final int N = 100000, L = difficulty.length;
        
        int[] maxProfit = new int[N + 1];
        
        for(int i = 0; i < L; i++){
            maxProfit[difficulty[i]] = Math.max(maxProfit[difficulty[i]], profit[i]);
        }
        
        for(int i = 2; i <= N; i++){
            maxProfit[i] = Math.max(maxProfit[i], maxProfit[i - 1]);
        }
        
        int ans = 0;
        for(int level : worker){
            ans += maxProfit[level];
        }
        
        return ans;
    }
}