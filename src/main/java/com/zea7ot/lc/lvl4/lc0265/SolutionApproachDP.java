/**
 * https://leetcode.com/problems/paint-house-ii/
 * 
 * https://leetcode.com/problems/paint-house-ii/discuss/69492/AC-Java-solution-without-extra-space
 */
package com.zea7ot.lc.lvl4.lc0265;

public class SolutionApproachDP {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        
        final int N = costs.length, K = costs[0].length;
        
        int min1 = -1, min2 = -2;
        
        for(int i = 0; i < N; i++){
            int last1 = min1, last2 = min2;
            min1 = -1;
            min2 = -1;
            
            for(int j = 0; j < K; j++){
                if(j != last1){
                    costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
                }else{
                    costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
                }
                
                if(min1 < 0 || costs[i][j] < costs[i][min1]){
                    min2 = min1;
                    min1 = j;
                }else if(min2 < 0 || costs[i][j] < costs[i][min2]){
                    min2 = j;
                }
            }
        }
        
        return costs[N - 1][min1];
    }
}