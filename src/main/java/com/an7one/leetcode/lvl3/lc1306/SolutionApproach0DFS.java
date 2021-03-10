/**
 * @author: Leon
 * https://leetcode.com/problems/jump-game-iii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.an7one.leetcode.lvl3.lc1306;

public class SolutionApproach0DFS {
    public boolean canReach(int[] nums, int start) {
        final int N = nums.length;
        boolean[] visited = new boolean[N];

        return dfs(start, visited, nums);
    }

    private boolean dfs(int cur, boolean[] visited, int[] nums) {
        final int N = nums.length;
        if (cur < 0 || cur >= N || visited[cur])
            return false;

        visited[cur] = true;
        if (nums[cur] == 0)
            return true;

        return dfs(cur + nums[cur], visited, nums) || dfs(cur - nums[cur], visited, nums);
    }
}
