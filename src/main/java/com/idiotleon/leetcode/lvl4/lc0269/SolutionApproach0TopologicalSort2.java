package com.idiotleon.leetcode.lvl4.lc0269;

import com.idiotleon.util.Constant;

import java.awt.Point;
import java.util.*;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/alien-dictionary/">LC0269</a>
 * <p>
 * Time Complexity:     O(N + M) - N represents all vertices, M represents all edges
 * Space Complexity:    O()
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0TopologicalSort2 {
    public String alienOrder(String[] words) {
        final List<Point> pairs = new ArrayList<>();
        final Set<Character> chs = new HashSet<>();

        final int N = words.length;

        // to build up the graph
        for (int i = 0; i < N; i++) {
            final String word = words[i];
            boolean alreadySet = false;
            int j;
            for (j = 0; j < word.length(); j++) {
                if (!alreadySet && i > 0 && j < words[i - 1].length() && words[i].charAt(j) != words[i - 1].charAt(j)) {
                    pairs.add(new Point(words[i].charAt(j), words[i - 1].charAt(j)));
                    alreadySet = true;
                }

                chs.add(word.charAt(j));
            }

            if (!alreadySet && i > 0 && j < words[i - 1].length()) {
                return "";
            }
        }

        // to topological sort
        final StringBuilder res = new StringBuilder();
        final int[] indegrees = new int[256];
        Arrays.fill(indegrees, Integer.MIN_VALUE);

        for (Character ch : chs) {
            indegrees[ch] = 0;
        }
        for (Point pair : pairs) {
            ++indegrees[pair.x];
        }

        final Deque<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < 256; ++i) {
            if (indegrees[i] == 0) {
                res.append((char) i);
                queue.addLast((char) i);
            }
        }

        while (!queue.isEmpty()) {
            final char predecessor = queue.removeFirst();

            for (Point pair : pairs) {
                if (pair.y == predecessor) {
                    --indegrees[pair.x];
                    if (indegrees[pair.x] == 0) {
                        res.append((char) pair.x);
                        queue.addLast((char) pair.x);
                    }
                }
            }
        }

        return res.length() == chs.size() ? res.toString() : "";
    }
}