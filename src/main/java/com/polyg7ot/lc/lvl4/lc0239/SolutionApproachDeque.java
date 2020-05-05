/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.polyg7ot.lc.lvl4.lc0239;

import java.util.LinkedList;

public class SolutionApproachDeque {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0) return new int[0];
        
        final int L = nums.length;
        int[] ans = new int[L - k + 1];
        int idx = 0;
        
        LinkedList<Integer> deque = new LinkedList<Integer>();
        
        for(int i = 0; i < L; i++){
            while(!deque.isEmpty() && deque.peekFirst() < i - k + 1)
                deque.removeFirst();
            
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.removeLast();
            
            deque.add(i);
            
            if(i >= k - 1){
                ans[idx++] = nums[deque.peekFirst()];
            }
        }
        
        return ans;
    }
}