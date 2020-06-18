/**
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * if the bottom being 0 means leaks.
 * only the concave of the bottom large than 0 can hold the water.
 * 
 * Time Complexity:     O(2 * N) ~ O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl4.lc0042.followup;

public class SolutionApproach1TwoPtrs {
    public int trap(int[] height){
        // sanity check
        if(height == null || height.length == 0) return 0;

        final int N = height.length;
        int water = 0;
        int left = 0, right = 0;

        while(right < N){
            while(right < N && height[right] == 0) right++;
            left = right - 1;
            while(right < N && height[right] != 0) right++;
            water += trap(height, left, right);
        }

        return water;
    }

    private int trap(int[] height, int lo, int hi){
        int left = lo, right = hi - 1;
        int leftMax = height[left], rightMax = height[right];
        int water = 0;

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