/**
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl4.lc0042;

public class SolutionApproach0TwoPtrs{
    public int trap(int[] height){  // [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
        // sanity check
        if(height == null || height.length == 0) return 0;
        
        final int N = height.length; // 12
        int left = 0, right = N - 1; // left: 0, right: 11
        int water = 0;
        int leftMax = height[left], rightMax = height[right]; // leftMax: 0, rightMax: 1
        
        while(left < right){
            if(leftMax < rightMax){
                water += leftMax - height[left];
                leftMax = Math.max(leftMax, height[++left]);
            }else{ 
                water += rightMax - height[right];
                rightMax = Math.max(rightMax, height[--right]);
            }
        }
        
        return water;
    }
}