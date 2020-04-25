/**
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
package com.null7ptr.lc.lvl4.lc0042;

public class SolutionApproachTwoPtrs1 {
    public int trap(int[] height) {
        if(height.length == 0) return 0;

        int left = 0, right = height.length - 1;
        int ans = 0;
        int leftMax = 0, rightMax = 0;
        
        while(left < right)
            if(height[left] < height[right]){
                if(height[left] >= leftMax) 
                    leftMax = height[left];
                else ans += (leftMax - height[left]);
                ++left;
            }else{
                if(height[right] >= rightMax)
                    rightMax = height[right];
                else ans += (rightMax - height[right]);
                --right;
            }
        
        return ans;
    }
}