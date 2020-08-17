/**
 * https://leetcode.com/problems/most-profit-assigning-work/
 * 
 * Time Complexity: O(Nlg(N) + Mlog(M)) 
 * Space Complexity: O(N)
 */
package com.zea7ot.leetcode.lvl2.lc0826;

import java.util.Arrays;

public class SolutionApproachSortingAndTwoPointers {
    public int maxProfitAssignment(int[] difficulty, 
                                   int[] profit, 
                                   int[] worker) {
        if(difficulty == null || difficulty.length == 0) return 0;
        
        final int N = difficulty.length;
        int[][] jobs = new int[N][2];
        for(int i = 0; i < N; i++){
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        
        Arrays.sort(worker);
        Arrays.sort(jobs, (j1, j2) -> Integer.compare(j1[0], j2[0]));
        
        int ans = 0;
        int i = 0;
        int best = 0;
        
        for(int level : worker){
            while(i < N && level >= jobs[i][0]){
                best = Math.max(best, jobs[i++][1]);
            }
            
            ans += best;
        }
        
        return ans;
    }
}