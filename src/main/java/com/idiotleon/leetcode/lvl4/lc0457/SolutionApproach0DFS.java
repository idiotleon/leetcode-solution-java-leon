/**
 * https://leetcode.com/problems/circular-array-loop/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(lg(N))
 * 
 * to detect if there is any cycle, of length strictly longer than 1,
 *  and in the same direction
 * 
 * References:
 *  https://leetcode.com/problems/circular-array-loop/discuss/395670/JAVA-simple-DFS-O(n)-beat-100-time-and-space
 */
package com.idiotleon.leetcode.lvl4.lc0457;

public class SolutionApproach0DFS {
    private static final int NOT_YET_VISITED = 0;
    private static final int VISITING = 1;
    private static final int VISITED = 2;

    public boolean circularArrayLoop(int[] nums) {
        final int N = nums.length;
        int[] visited = new int[N];
        // omitted
        // Arrays.fill(visited, NOT_YET_VISITED);

        for (int i = 0; i < N; ++i) {
            if (visited[i] == NOT_YET_VISITED && dfs(i, visited, nums))
                return true;
        }

        return false;
    }

    private boolean dfs(int cur, int[] visited, int[] nums) {
        final int N = nums.length;
        if (visited[cur] == VISITING)
            return true;
        if (visited[cur] == VISITED)
            return false;

        visited[cur] = VISITING;

        int next = cur + nums[cur];
        next %= N;
        if (next < 0)
            next += N;

        // to return false if length is one
        // to return false if coming from different directions
        if (next == cur || nums[next] * nums[cur] < 0) {
            visited[cur] = VISITED;
            return false;
        }

        if (dfs(next, visited, nums))
            return true;
        visited[cur] = VISITED;
        return false;
    }
}
