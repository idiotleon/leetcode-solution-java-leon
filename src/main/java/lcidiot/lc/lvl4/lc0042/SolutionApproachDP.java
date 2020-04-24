/**
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

package main.java.lcidiot.lc.lvl4.lc0042;

public class SolutionApproachDP{
    public int trap(int[] height) {
        final int N = height.length;
        int[] l = new int[N], r = new int[N];
        int ans = 0;
        
        for(int i = 0; i < N; ++i)
            l[i] = i == 0 ? height[i] : Math.max(l[i - 1], height[i]);
        
        for(int i = N - 1; i >= 0; --i)
            r[i] = i == N - 1 ? height[i] : Math.max(r[i + 1], height[i]);
        
        for(int i = 0; i < N; ++i)
            ans += Math.min(l[i], r[i]) - height[i];
            
        return ans;
    }
}