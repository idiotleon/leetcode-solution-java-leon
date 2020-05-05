/**
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
package com.polyg7ot.lc.lvl4.lc0042;

public class SolutionApproachTwoPtrs{
    public int trap(int[] height){
        if(height.length == 0) return 0;
        
        int left = 0, right = height.length - 1;
        int ans = 0;
        int leftMax = height[left], rightMax = height[right];
        
        while(left < right)
            if(leftMax < rightMax){
                ans += leftMax - height[left];
                leftMax = Math.max(leftMax, height[++left]);
            }else{
                ans += rightMax - height[right];
                rightMax = Math.max(rightMax, height[--right]);
            }
        
        return ans;
    }
}