/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * 
 * https://leetcode.com/problems/subarray-sum-equals-k/discuss/301242/General-summary-of-what-kind-of-problem-can-cannot-solved-by-Two-Pointers
 * 
 * https://leetcode.com/problems/subarray-sum-equals-k/discuss/102106/Java-Solution-PreSum-%2B-HashMap
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package main.java.lcidiot.lc.lvl3.lc0560;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproachPresum {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<Integer, Integer>();
        preSum.put(0, 1);
        
        for(int num : nums){
            sum += num;
            if(preSum.containsKey(sum - k)){
                result += preSum.get(sum - k);
            }
            
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
}