/**
 * https://leetcode.com/problems/continuous-subarray-sum/
 * 
 * https://leetcode.com/problems/continuous-subarray-sum/discuss/99499/Java-O(n)-time-O(k)-space
 * 
 * the remainder theorem:
 * (a+(n*x))%x is same as (a%x)
 */
package main.java.lcidiot.lc.lvl3.lc0523;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproachHashMap {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSum = new HashMap<Integer, Integer>();
        preSum.put(0, -1);
        
        int runningSum = 0;
        for(int i = 0; i < nums.length; i++){
            runningSum += nums[i];
            if(k != 0) runningSum %= k;
            Integer prev = preSum.get(runningSum);
            if(prev != null){
                if(i - prev > 1){
                    return true;
                }
            }else{
                preSum.put(runningSum, i);
            }
        }
        
        return false;
    }
}