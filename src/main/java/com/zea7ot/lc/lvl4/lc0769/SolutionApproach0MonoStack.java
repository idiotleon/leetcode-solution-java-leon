/**
 * https://leetcode.com/problems/max-chunks-to-make-sorted/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/max-chunks-to-make-sorted-ii/discuss/135830/c%2B%2B-Using-Stack-with-O(n)-space-and-time-complexity.-With-7-lines.-4ms.-Beats-100
 * 
 * Similar Questions:
 *  https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
 *  https://leetcode.com/problems/jump-game/
 *  https://leetcode.com/problems/product-of-array-except-self/
 */
package com.zea7ot.lc.lvl4.lc0769;

import java.util.Stack;

public class SolutionApproach0MonoStack {
    public int maxChunksToSorted(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        final int N = nums.length;

        // a non-decreasing stack
        Stack<Integer> stack = new Stack<Integer>();        
        for(int i = 0; i < N; i++){
            int curMax = stack.isEmpty() ? nums[i] : Math.max(stack.peek(), nums[i]);
            
            while(!stack.isEmpty() && stack.peek() > nums[i]){
                stack.pop();
            }
            
            stack.push(curMax);
        }
        
        return stack.size();
    }
}