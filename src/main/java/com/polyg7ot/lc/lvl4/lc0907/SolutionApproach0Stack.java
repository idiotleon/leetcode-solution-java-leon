/**
 * https://leetcode.com/problems/sum-of-subarray-minimums/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * References:
 *  https://leetcode.com/problems/sum-of-subarray-minimums/discuss/170750/C%2B%2BJavaPython-Stack-Solution
 *  https://leetcode.com/problems/sum-of-subarray-minimums/discuss/170750/C++JavaPython-Stack-Solution/337512
 */
package com.polyg7ot.lc.lvl4.lc0907;

import java.util.Stack;

public class SolutionApproach0Stack {
    public int sumSubarrayMins(int[] nums) {
        final int L = nums.length, MOD = (int)1e9 + 7;
        int ans = 0, j = 0, k = 0;
        
        Stack<Integer> idxStack = new Stack<Integer>();
        for(int i = 0; i <= L; i++){
            while(!idxStack.isEmpty() && nums[idxStack.peek()] > (i == L ? 0 : nums[i])){
                // only to pop out elements when nums[stack.peek()] > nums[i],
                // nums[k] <= nums[j], nums[j] > nums[i]
                j = idxStack.pop();
                // nums[k] is the previous less or equal number
                // nums[i] is the next less number
                k = idxStack.isEmpty() ? -1 : idxStack.peek();
                ans = (ans + nums[j] * (i - j) * (j - k)) % MOD;
            }
            idxStack.push(i);
        }
        
        return ans;
    }
}