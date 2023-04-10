/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package com.idiotleon.leetcode.lvl4.lc0540;

import java.util.Stack;

public class SolutionApproach2OnePass1 {
    public int singleNonDuplicate(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int num : nums){
            if(stack.isEmpty()){
                stack.push(num);
            }else{
                if(stack.peek() == num){
                    stack.pop();
                }else break;
            }
        }
        
        return stack.pop();
    }
}