/**
 * https://leetcode.com/problems/gas-station/
 */
package com.polyg7ot.lc.lvl3.lc0134;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // sanity check
        if(gas == null || cost == null || gas.length == 0 || cost.length == 0)
            return -1;
        
        int curTank = 0, startPos = 0, totalTank = 0;
        
        for(int i = 0; i < gas.length; i++){
            curTank += gas[i] - cost[i];
            
            if(curTank < 0){
                startPos = i + 1;
                curTank = 0;
            }
            
            totalTank += gas[i] - cost[i];
        }
        
        return totalTank >= 0 ? startPos : -1;
    }
}