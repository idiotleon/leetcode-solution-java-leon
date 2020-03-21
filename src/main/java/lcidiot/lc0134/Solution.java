/**
 * https://leetcode.com/problems/gas-station/
 */
package main.java.lcidiot.lc0134;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
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