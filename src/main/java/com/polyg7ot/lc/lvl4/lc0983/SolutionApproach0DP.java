/**
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 * 
 * Time Complexity:     O(LAST_DAY)
 * Space Complexity:    O(LAST_DAY)
 * 
 * a bottom-up approach
 * 
 * References:
 *  https://leetcode.com/problems/minimum-cost-for-tickets/discuss/227130/Java-DP-Solution-with-detailed-comment-and-explanation
 *  https://leetcode.com/problems/minimum-cost-for-tickets/discuss/226659/Two-DP-solutions-with-pictures
 */
package com.polyg7ot.lc.lvl4.lc0983;

public class SolutionApproach0DP {
    public int mincostTickets(int[] days, int[] costs) {
        final int LAST_DAY = days[days.length - 1];
        int[] dp = new int[LAST_DAY + 1];
        boolean[] isTravelDay = new boolean[LAST_DAY + 1];
        
        for(int day : days) isTravelDay[day] = true;
        
        for(int i = 1; i <= LAST_DAY; i++){
            if(!isTravelDay[i]){
                dp[i] = dp[i - 1];
                continue;
            }
            
            dp[i] = costs[0] + dp[i - 1];
            dp[i] = Math.min(costs[1] + dp[Math.max(0, i - 7)], dp[i]);
            dp[i] = Math.min(costs[2] + dp[Math.max(0, i - 30)], dp[i]);
        }
        
        return dp[LAST_DAY];
    }
}