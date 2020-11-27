/**
 * https://leetcode.com/problems/synonymous-sentences/
 * 
 * Time Complexity:     O(N * L)
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/synonymous-sentences/discuss/430604/Java-BFS-Solution-Picture-Explain-Clean-code
 */
package com.zea7ot.leetcode.lvl4.lc1258;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SolutionApproach0BFS {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, List<String>> graph = buildGraph(synonyms);

        Deque<String> queue = new ArrayDeque<>();
        queue.add(text);

        final Set<String> SEEN = new TreeSet<>();
        SEEN.add(text);

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                String cur = queue.poll();

                String[] words = cur.split("\\s");
                final int N = words.length;

                for (int j = 0; j < N; ++j) {
                    if (!graph.containsKey(words[j]))
                        continue;
                    for (String synonym : graph.get(words[j])) {
                        words[j] = synonym;
                        String newText = String.join(" ", words);
                        if (!SEEN.add(newText))
                            continue;
                        queue.offer(newText);
                    }
                }
            }
        }

        return new ArrayList<>(SEEN);
    }

    private Map<String, List<String>> buildGraph(List<List<String>> synonyms) {
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> pair : synonyms) {
            String u = pair.get(0);
            String v = pair.get(1);

            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(v);
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(v).add(u);
        }

        return graph;
    }
}
