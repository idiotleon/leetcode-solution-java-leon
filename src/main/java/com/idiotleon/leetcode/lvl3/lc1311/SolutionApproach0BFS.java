/**
 * @author: Leon
 * https://leetcode.com/problems/get-watched-videos-by-your-friends/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.idiotleon.leetcode.lvl3.lc1311;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0BFS {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(id);

        final Set<Integer> SEEN = new HashSet<>();
        SEEN.add(id);

        final Map<String, Integer> FREQS = new HashMap<>();

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int sz = 0; sz < SIZE; ++sz) {
                int cur = queue.poll();

                if (level == 0) {
                    for (String movie : watchedVideos.get(cur)) {
                        FREQS.put(movie, FREQS.getOrDefault(movie, 0) + 1);
                    }
                } else {
                    for (int next : friends[cur]) {
                        if (!SEEN.add(next))
                            continue;
                        queue.offer(next);
                    }
                }
            }

            --level;
        }

        List<String> ans = new ArrayList<>(FREQS.keySet());
        Collections.sort(ans, (a, b) -> {
            if (FREQS.get(a) != FREQS.get(b)) {
                return Integer.compare(FREQS.get(a), FREQS.get(b));
            } else {
                return a.compareTo(b);
            }
        });

        return ans;
    }
}
