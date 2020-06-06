/**
 * https://leetcode.com/problems/sum-of-subarray-minimums/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(2 * N) ~ O(N)
 * 
 * to maintain 2 strictly increasing stacks, to fill left and right integer array up
 * 
 * https://leetcode.com/problems/sum-of-subarray-minimums/discuss/178876/stack-solution-with-very-detailed-explanation-step-by-step
 */
package com.zea7ot.lc.lvl4.lc0907;

import java.util.Stack;

public class SolutionApproach0Stack1 {
    public int sumSubarrayMins(int[] nums) {
        final int L = nums.length, MOD = (int)1e9 + 7;
        int ans = 0;
        // to contain left/previous smaller element at index i
        int[] left = new int[L];
        // to contain right/next smaller element at index i
        int[] right = new int[L];
        
        Stack<int[]> stack1 = new Stack<int[]>(), stack2 = new Stack<int[]>();
        for(int i = 0; i < L; i++){
            int count = 1;
            while(!stack1.isEmpty() && stack1.peek()[0] > nums[i]){
                count += stack1.pop()[1];
            }
            stack1.push(new int[]{nums[i], count});
            left[i] = count;
        }
        
        for(int i = L - 1; i >= 0; i--){
            int count = 1;
            while(!stack2.isEmpty() && stack2.peek()[0] >= nums[i]){
                count += stack2.pop()[1];
            }
            
            stack2.push(new int[]{nums[i], count});
            right[i] = count;
        }
        
        for(int i = 0; i < L; i++){
            ans = (ans + nums[i] * left[i] * right[i]) % MOD;
        }
        
        return ans;
    }
}