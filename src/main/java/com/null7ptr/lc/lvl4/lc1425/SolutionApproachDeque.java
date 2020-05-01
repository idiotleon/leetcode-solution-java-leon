/**
 * https://leetcode.com/problems/constrained-subsequence-sum/
 */
package com.null7ptr.lc.lvl4.lc1425;

import java.util.LinkedList;

public class SolutionApproachDeque {
    public int constrainedSubsetSum(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0) return 0;
        
        LinkedList<Integer> deque = new LinkedList<Integer>();

        int ans = nums[0];
        for(int i = 0; i < nums.length; i++){
            nums[i] += deque.isEmpty() ? 0 : deque.peekFirst();
            ans = Math.max(ans, nums[i]);
            
            while(!deque.isEmpty() && nums[i] > deque.peekLast()){
                deque.removeLast();
            }
            
            if(nums[i] > 0) deque.add(nums[i]);
            
            if(i >= k && !deque.isEmpty() && deque.peekFirst() == nums[i - k]){
                deque.removeFirst();
            }
        }
        
        return ans;
    }
}