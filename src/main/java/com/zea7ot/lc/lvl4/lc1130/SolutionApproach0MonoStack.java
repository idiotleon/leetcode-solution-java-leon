/**
 * https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/339959/One-Pass-O(N)-Time-and-Space
 * 
 * Similar Problems:
 *  https://leetcode.com/problems/next-greater-element-ii/
 *  https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/340489/Summary-and-reasoning-of-different-solutions
 */
package com.zea7ot.lc.lvl4.lc1130;

import java.util.Stack;

public class SolutionApproach0MonoStack {
    public int mctFromLeafValues(int[] nums) {
        int ans = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(Integer.MAX_VALUE);
        
        for(int num : nums){
            while(stack.peek() <= num){
                int mid = stack.pop();
                ans += mid * Math.min(stack.peek(), num);
            }
            stack.push(num);
        }
        
        while(stack.size() > 2){
            ans += stack.pop() * stack.peek();
        }
        
        return ans;
    }
}