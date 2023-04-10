/**
 * https://leetcode.com/problems/similar-string-groups/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/similar-string-groups/discuss/132318/Simple-Java-Solution-using-DFS/139892
 */
package com.idiotleon.leetcode.lvl4.lc0839;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0BFS {
    public int numSimilarGroups(String[] arr) {
        // sanity check
        if (arr == null || arr.length == 0)
            return 0;

        final int N = arr.length;
        boolean[] visited = new boolean[N];
        Deque<String> queue = new ArrayDeque<String>();

        int ans = 0;
        for (int i = 0; i < N; ++i) {
            if (visited[i])
                continue;

            visited[i] = true;
            ++ans;
            queue.offer(arr[i]);

            while (!queue.isEmpty()) {
                String cur = queue.poll();
                for (int j = i + 1; j < N; ++j) {
                    if (visited[j])
                        continue;
                    if (!isSimilar(cur, arr[j]))
                        continue;
                    visited[j] = true;
                    queue.offer(arr[j]);
                }
            }
        }

        return ans;
    }

    private boolean isSimilar(String source, String target) {
        final int LEN_S = source.length();
        int diff = 0;
        for (int i = 0; i < LEN_S; ++i) {
            if (source.charAt(i) != target.charAt(i))
                if (++diff == 3)
                    return false;
        }

        return (diff == 2 || diff == 0);
    }
}