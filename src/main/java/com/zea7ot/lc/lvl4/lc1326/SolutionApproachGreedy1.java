/**
 * https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
 * 
 * https://www.youtube.com/watch?v=G88X89Eo2C0&list=PLLuMmzMTgVK5Igci8P3d88XpoyeIA1Fl-&index=2
 * 
 * Reduction:
 * If problem A can be reduced to problem B efficiently (polynomial time), solving A is no harder than solving B.
 * We write A <= B, which means A is "easier".
 * 
 * We have a chance, but it is not guaranteed, to find a better solution (lower time/space complexity) for A!
 * 
 * 1326 -> 45
 * https://leetcode.com/problems/jump-game-ii/
 * Time Complexity: O(n)
 * Space Complexity: O(n) / O(1)
 * 
 * 1326 -> 1024
 * https://leetcode.com/problems/video-stitching/
 * Time Complexity: O(nlgn)
 * Space Complexity: O(n) / O(1)
 */
package com.zea7ot.lc.lvl4.lc1326;

public class SolutionApproachGreedy1 {
    public int minTaps(int n, int[] ranges) {
        // sanity check
        if(n <= 0) return -1;
        
        // O(n) reduction
        int[] nums = new int[ranges.length];
        for(int i = 0; i <= n; i++){
            int s = Math.max(0, i - ranges[i]);
            nums[s] = i + ranges[i];
        }
        
        // 45: Jump Game II
        int steps = 0;
        int left = 0, end = 0;
        for(int i = 0; i <= n; i++){
            if(i > end) return -1;
            if(i > left) {  // this means, a jump is required
                ++steps;
                left = end;
            }

            end = Math.max(end, nums[i]);
        }
        
        return steps;
    }
}