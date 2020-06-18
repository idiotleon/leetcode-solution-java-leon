/**
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * Time Complexity:     O(2 * N) ~ O(N)
 * Space Complexity:    O(2 * N) ~ O(N)
 */
package com.zea7ot.lc.lvl4.lc0042.followup;

public class SolutionApproach1DP {
    public int trap(int[] height){
        // sanity check
        if(height == null || height.length == 0) return 0;

        final int N = height.length;
        int left = 0, right = 0;
        int water = 0;
        while(right < N){
            while(right < N && height[right] == 0) right++;
            left = right;
            while(right < N && height[right] != 0) right++;
            water += trap(height, left, right - 1);
        }
        return water;
    }

    private int trap(int[] height, int lo, int hi){
        if(lo >= hi) return 0;
        final int N = hi - lo + 1;
        if(N < 3) return 0;
        int[] left = new int[N], right = new int[N];
        left[0] = height[lo];
        right[N - 1] = height[hi];
        int water = 0;

        for(int i = 1; i < N; i++){
            left[i] = Math.max(left[i - 1], height[i + lo]);
        }

        for(int i = N - 2; i >= 0; i--){
            right[i] = Math.max(right[i + 1], height[i + lo]);
        }

        for(int i = 0; i < N; i++){
            water += Math.min(left[i], right[i]) - height[i + lo];
        }

        return water;
    }
}