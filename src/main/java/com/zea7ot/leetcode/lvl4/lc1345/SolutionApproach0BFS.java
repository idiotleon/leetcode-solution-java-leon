/**
 * https://leetcode.com/problems/jump-game-iv/
 *
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(`N`)
 *
 * double-end BFS
 *
 * References:
 *  https://leetcode.com/problems/jump-game-iv/discuss/507950/Java-Bidirectional-BFS
 */
package com.zea7ot.leetcode.lvl4.lc1345;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0BFS {
    public int minJumps(int[] nums) {
        final int N = nums.length;
        if (N == 1)
            return 0;

        Map<Integer, List<Integer>> idxMap = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            idxMap.putIfAbsent(nums[i], new ArrayList<>());
            idxMap.get(nums[i]).add(i);
        }

        boolean[] visited = new boolean[N];

        Set<Integer> head = new HashSet<>();
        head.add(0);
        visited[0] = true;

        Set<Integer> tail = new HashSet<>();
        tail.add(N - 1);
        visited[N - 1] = true;

        int steps = 0;

        while (!head.isEmpty() && !tail.isEmpty()) {
            if (head.size() > tail.size()) {
                swap(head, tail);
            }

            Set<Integer> next = new HashSet<>();
            for (int idx : head) {
                int loNext = idx - 1;
                if (loNext == N - 1)
                    return 1 + steps;
                if (loNext >= 0 && loNext < N && !visited[loNext]) {
                    next.add(loNext);
                    visited[loNext] = true;
                }

                int hiNext = idx + 1;
                if (hiNext == N - 1)
                    return 1 + steps;

                if (hiNext >= 0 && hiNext < N && !visited[hiNext]) {
                    next.add(hiNext);
                    visited[hiNext] = true;
                }

                List<Integer> equalValueIdxes = idxMap.get(nums[idx]);
                for (int equalValueNext : equalValueIdxes) {
                    if (equalValueNext == N - 1)
                        return 1 + steps;

                    if (equalValueNext >= 0 && equalValueNext < N && !visited[equalValueNext]) {
                        next.add(equalValueNext);
                        visited[equalValueNext] = true;
                    }
                }
                equalValueIdxes.clear();
            }

            head = next;
            ++steps;
        }

        return -1;
    }

    private void swap(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> temp = set1;
        set1 = set2;
        set2 = temp;
    }
}
