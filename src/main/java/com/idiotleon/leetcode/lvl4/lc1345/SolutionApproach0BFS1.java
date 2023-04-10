package com.idiotleon.leetcode.lvl4.lc1345;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0BFS1 {
    public int minJumps(int[] nums) {
        final int N = nums.length;

        Map<Integer, List<Integer>> idxMap = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            final int KEY = nums[i];
            idxMap.putIfAbsent(KEY, new ArrayList<>());
            idxMap.get(KEY).add(i);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);

        final Set<Integer> SEEN = new HashSet<>();
        SEEN.add(0);

        int steps = 0;

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int sz = 0; sz < SIZE; ++sz) {
                int curIdx = queue.poll();
                if (curIdx == N - 1)
                    return steps;

                int loNext = curIdx - 1;
                if (loNext >= 0 && loNext < N && SEEN.add(loNext)) {
                    queue.offer(loNext);
                }

                int hiNext = curIdx + 1;
                if (hiNext >= 0 && hiNext < N && SEEN.add(hiNext)) {
                    queue.offer(hiNext);
                }

                List<Integer> equalValueIdxes = idxMap.get(nums[curIdx]);
                for (int equalValueIdx : equalValueIdxes) {
                    if (!SEEN.add(equalValueIdx))
                        continue;
                    queue.offer(equalValueIdx);
                }
                equalValueIdxes.clear();
            }

            ++steps;
        }

        return -1;
    }
}
