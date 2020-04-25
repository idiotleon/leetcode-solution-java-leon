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
 * 1326 -> 1024
 * https://leetcode.com/problems/video-stitching/
 * Time Complexity: O(nlgn)
 * Space Complexity: O(n) / O(1)
 * 
 * 1326 -> 45
 * https://leetcode.com/problems/jump-game-ii/
 * Time Complexity: O(n)
 * Space Complexity: O(n) / O(1)
 */
package com.null7ptr.lc.lvl4.lc1326;

import java.util.Arrays;

public class SolutionApproachGreedy2 {
    public int minTaps(int n, int[] ranges) {
        // sanity check
        if(n <= 0) return 0;
        
        // O(n) reduction
        int[][] clips = new int[n + 1][2];
        for(int i = 0; i <= n; i++){
            clips[i] = new int[]{i - ranges[i], i + ranges[i]};
        }
        
        // 1024. Video Stiching
        Arrays.sort(clips, (c1, c2) -> Integer.compare(c1[0], c2[0]));
        int ans = 0;
        int i = 0, left = 0, end = 0;
        while(end < n){
            // to extend to the rightmost w.r.t clips[i][0] <= left
            while(i <= n && clips[i][0] <= left){
                end = Math.max(end, clips[i++][1]);
            }
            
            // situations where it cannot be extended
            if(left == end) return -1;
            left = end;
            ++ans;
        }
        
        return ans;
    }
}