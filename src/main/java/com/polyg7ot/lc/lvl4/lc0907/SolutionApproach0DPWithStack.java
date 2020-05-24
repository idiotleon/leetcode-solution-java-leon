/**
 * https://leetcode.com/problems/sum-of-subarray-minimums/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * dp[i + 1]: sum of minimum of subarrays which ends with nums[i]
 * https://leetcode.com/problems/sum-of-subarray-minimums/discuss/170769/Java-O(n)-monotone-idxStack-with-DP
 */
package com.polyg7ot.lc.lvl4.lc0907;

import java.util.Stack;

public class SolutionApproach0DPWithStack {
    public int sumSubarrayMins(int[] nums) {
        final int L = nums.length, MOD = (int)1e9 + 7;
        int ans = 0;
        
        int[] dp = new int[L + 1];
        
        Stack<Integer> idxStack = new Stack<Integer>();
        idxStack.push(-1);
        
        for(int i = 0; i < L; i++){
            while(idxStack.peek() != -1 && nums[i] <= nums[idxStack.peek()]){
                idxStack.pop();
            }   
            
            dp[i + 1] = (dp[idxStack.peek() + 1] + (i - idxStack.peek()) * nums[i]) % MOD;
            idxStack.push(i);
            ans += dp[i + 1];
            ans %= MOD;
        }
        
        return ans;
    }
}