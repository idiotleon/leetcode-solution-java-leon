/**
 * https://leetcode.com/problems/minimum-cost-for-tickets/discuss/227321/Top-down-DP-Logical-Thinking
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/minimum-cost-for-tickets/discuss/227321/Top-down-DP-Logical-Thinking
 *  https://leetcode.com/problems/minimum-cost-for-tickets/discuss/226659/Two-DP-solutions-with-pictures
 *  https://leetcode.com/problems/minimum-cost-for-tickets/discuss/504403/DP-it's-not-easy-as-you-thought
 */
package com.zea7ot.leetcode.lvl4.lc0983;

public class SolutionApproach0DFSMemo {
    private static final int DAY = 1;
    private static final int WEEK = 7;
    private static final int MONTH = 30;

    public int mincostTickets(int[] days, int[] costs) {
        final int L = days.length;
        int[] memo = new int[L];
        return dfs(days, 0, costs, memo);
    }
    
    private int dfs(int[] days, int day, int[] costs, int[] memo){
        if(day == days.length) return 0;
        
        if(memo[day] != 0) return memo[day];
        
        int totalCostDay = costs[0] + dfs(days, getNextDayToBuy(days, day, DAY), costs, memo);
        int totalCostWeek = costs[1] + dfs(days, getNextDayToBuy(days, day, WEEK), costs, memo);
        int totalCostMonth = costs[2] + dfs(days, getNextDayToBuy(days, day, MONTH), costs, memo);
        
        int minCost = Math.min(totalCostDay, Math.min(totalCostWeek, totalCostMonth));
        
        return memo[day] = minCost;
    }
    
    private int getNextDayToBuy(int[] days, int day, int duration){
        int endDay = days[day] + duration - 1;
        int newDay = day;
        
        while(newDay < days.length && days[newDay] <= endDay){
            newDay++;
        }
        
        return newDay;
    }
}